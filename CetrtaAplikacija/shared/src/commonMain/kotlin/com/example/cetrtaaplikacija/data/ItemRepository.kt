package com.example.cetrtaaplikacija.data

import baza.list.db.ListItem

class ItemRepository(private val localDataSource: LocalDataSource) {

    fun getAllItems(): List<ListItem> {
        return localDataSource.getAllItems()
    }

    fun getItemsByListId(listId: Long): List<ListItem> {
        return localDataSource.getItems(listId)
    }

    fun insertItems(items: List<ListItem>) {
        localDataSource.insertItems(items)
    }

    fun updateItems(items: List<ListItem>) {
        localDataSource.updateItems(items)
    }

    fun deleteItem(id: Long) {
        localDataSource.deleteItem(id)
    }
}
