import SwiftUI
import shared

struct ContentView: View {
	

	var body: some View {
        ListScreen(viewModel: .init())
	}
}

struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
		ContentView()
	}
}
