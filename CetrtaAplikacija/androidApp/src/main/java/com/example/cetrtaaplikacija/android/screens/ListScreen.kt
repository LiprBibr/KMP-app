package com.example.cetrtaaplikacija.android.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.cetrtaaplikacija.presentation.ListViewModel
import data.ListEntity


@Composable
fun ListScreen(
    listViewModel: ListViewModel
) {
    val listState = listViewModel.listState.collectAsState()

    Column {
        AppBar()

        when {
            listState.value.loading -> Loader()
            listState.value.error != null -> ErrorMessage(message = listState.value.error!!)
            listState.value.lists.isNotEmpty() -> ListsListView(lists = listState.value.lists)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBar() {
    TopAppBar(
        title = { Text(text = "Shopping List") },
    )
}

@Composable
fun Loader() {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Text(text = "Loading...")
    }
}

@Composable
fun ErrorMessage(message: String) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(text = "Error: $message")
    }
}

@Composable
fun ListsListView(lists: List<ListEntity>) {
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(lists) { list ->
            ListItemView(list = list)
        }
    }
}

@Composable
fun ListItemView(list: ListEntity) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(text = list.title) // Display the list title
        Text(text = "Created At: ${list.created_at}") // Display the createdAt field
    }
}
