package com.example.cetrtaaplikacija.data

import baza.list.db.ListEntity

class ListRepository(
    private val localDataSource: LocalDataSource
) {

    fun getAllLists(): List<ListEntity> {
        return localDataSource.getAllLists()
    }

    fun getListById(id: Long): ListEntity? {
        return localDataSource.getList(id).firstOrNull()
    }

    fun insertLists(lists: List<ListEntity>) {
        localDataSource.insertLists(lists)
    }

    fun updateLists(lists: List<ListEntity>) {
        localDataSource.updateLists(lists)
    }

    fun deleteList(id: Long) {
        localDataSource.deleteList(id)
    }
}
