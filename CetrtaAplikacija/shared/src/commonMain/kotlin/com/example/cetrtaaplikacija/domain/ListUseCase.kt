package com.example.cetrtaaplikacija.domain.usecase

import com.example.cetrtaaplikacija.data.ItemRepository
import com.example.cetrtaaplikacija.data.ListRepository
import baza.list.db.ListEntity
import baza.list.db.ListItem

class ListUseCase(
    private val listRepository: ListRepository,
    private val itemRepository: ItemRepository
) {

    // List
    fun getAllLists(): List<ListEntity> = listRepository.getAllLists()

    fun getListById(id: Long): ListEntity? = listRepository.getListById(id)

    fun insertLists(lists: List<ListEntity>) = listRepository.insertLists(lists)

    fun updateLists(lists: List<ListEntity>) = listRepository.updateLists(lists)

    fun deleteList(id: Long) = listRepository.deleteList(id)

    // Item
    fun getAllItems(): List<ListItem> = itemRepository.getAllItems()

    fun getItemsByListId(listId: Long): List<ListItem> = itemRepository.getItemsByListId(listId)

    fun insertItems(items: List<ListItem>) = itemRepository.insertItems(items)

    fun updateItems(items: List<ListItem>) = itemRepository.updateItems(items)

    fun deleteItem(id: Long) = itemRepository.deleteItem(id)
}

