//
//  ListScreen.swift
//  iosApp
//
//  Created by Matic Cegnar on 29. 1. 25.
//  Copyright © 2025 orgName. All rights reserved.
//

import SwiftUI
import shared

extension ListScreen {
    
    @MainActor
    class ListViewModelWrapper: ObservableObject {
        let listViewModel: ListViewModel

        @Published var listState: ListState

        init(viewModel: ListViewModel) {
            self.listViewModel = viewModel
            self.listState = listViewModel.observeShoppingLists().value
        }

        func startObserving() {
            Task {
                for await lists in listViewModel.observeShoppingLists() {
                    self.listState = lists
                }
            }
        }
    }
}

struct ListScreen: View {
    
    @ObservedObject private(set) var viewModel: ListViewModelWrapper
    
    var body: some View {
        VStack {
            AppBar()
            
            if viewModel.listState.loading {
                Loader()
            } else if let error = viewModel.listState.error {
                ErrorMessage(message: error)
            } else if !viewModel.listState.lists.isEmpty {
                ScrollView {
                    LazyVStack(spacing: 10) {
                        ForEach(viewModel.listState.lists, id: \.id) { list in
                            ListItemView(list: list)
                        }
                    }
                }
            }
        }
        .onAppear {
            self.viewModel.startObserving()
        }
    }
}


struct AppBar: View {
    var body: some View {
        Text("Shopping Lists")
            .font(.largeTitle)
            .fontWeight(.bold)
            .padding()
    }
}


struct ListItemView: View {
    var list: ListEntity

    var body: some View {
        VStack(alignment: .leading, spacing: 8) {
            Text(list.title)
                .font(.title2)
                .fontWeight(.bold)
            Text("Created At: \(formatDate(date: list.created_at))") // Properly formatted date
                .font(.subheadline)
                .foregroundColor(.gray)
        }
        .padding()
        .frame(maxWidth: .infinity, alignment: .leading)
        .background(Color(.systemGray6))
        .cornerRadius(8)
        .padding(.horizontal)
    }
}


func formatDate(date: String) -> String {
    
    let inputFormatter = ISO8601DateFormatter()
    let outputFormatter = DateFormatter()
    outputFormatter.dateFormat = "yyyy-MM-dd HH:mm"

    if let formattedDate = inputFormatter.date(from: date) {
        return outputFormatter.string(from: formattedDate)
    } else {
        return "Invalid Date"
    }
}


struct Loader: View {
    var body: some View {
        ProgressView("Loading...")
            .progressViewStyle(CircularProgressViewStyle())
    }
}


struct ErrorMessage: View {
    var message: String

    var body: some View {
        Text("Error: \(message)")
            .foregroundColor(.red)
            .font(.headline)
            .padding()
    }
}


