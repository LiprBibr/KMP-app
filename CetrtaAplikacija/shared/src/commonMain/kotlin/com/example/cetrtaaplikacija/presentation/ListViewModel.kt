package com.example.cetrtaaplikacija.presentation

import com.example.cetrtaaplikacija.data.ListState
import data.ListEntity
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.datetime.toLocalDateTime

class ListViewModel: BaseViewModel() {

    private val _listState: MutableStateFlow<ListState> = MutableStateFlow(ListState(loading = true))

    val listState: StateFlow<ListState> get() = _listState.asStateFlow()

    init {
        getLists()
    }

    private fun getLists() {
        scope.launch {
            delay(2000)
            _listState.emit(ListState(error = "Something went wrong"))

            delay(2000)
            val fetchedLists = fetchLists()

            _listState.emit(ListState(lists = fetchedLists))
        }
    }

    fun observeShoppingLists() = listState

    suspend fun fetchLists(): List<ListEntity> = getMockLists

    private val getMockLists = listOf(
            ListEntity(
                id = 1L,
                title = "Nakupovanje za vikend",
                created_at = "2025-01-20T10:30:00".toLocalDateTime()
            ),
            ListEntity(
                id = 2L,
                title = "Oprema za šolo",
                created_at = "2025-01-22T08:45:00".toLocalDateTime()
            ),
            ListEntity(
                id = 3L,
                title = "Tedenski nakup",
                created_at = "2025-01-24T18:15:00".toLocalDateTime()
            )
        )

}