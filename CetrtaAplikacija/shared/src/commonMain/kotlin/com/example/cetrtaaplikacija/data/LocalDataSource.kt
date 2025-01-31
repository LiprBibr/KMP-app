package com.example.cetrtaaplikacija.data

import baza.list.db.ListBaza
import baza.list.db.ListEntity
import baza.list.db.ListItem

class LocalDataSource (private val database: ListBaza) {

    fun getAllLists() : List<ListEntity> =
        database.listBazaQueries.selectAllLists().executeAsList()

    fun getList(id: Long) : List<ListEntity> =
        database.listBazaQueries.selectListById(id).executeAsList()

    fun insertLists(listE: List<ListEntity>) {
        database.listBazaQueries.transaction {
            listE.forEach { listEntity ->
                insertList(listEntity)
            }
        }
    }

    private fun insertList(listEntity: ListEntity) {
        database.listBazaQueries.insertList(
            title = listEntity.title,
            created_at = listEntity.created_at.toString()
        )
    }

    fun updateLists(listE: List<ListEntity>) {
        database.listBazaQueries.transaction {
            listE.forEach { listEntity ->
                updateList(listEntity)
            }
        }
    }

    private fun updateList(listEntity: ListEntity) {
        database.listBazaQueries.updateList(
            id = listEntity.id,
            title = listEntity.title,
            created_at = listEntity.created_at.toString()
        )
    }

    fun deleteList(id: Long) {
        database.listBazaQueries.deleteList(id)
    }

    //item

    fun getAllItems(): List<ListItem> =
        database.listBazaQueries.selectAllItems().executeAsList()

    fun getItems(listId: Long): List<ListItem> =
        database.listBazaQueries.selectItemsByListId(listId).executeAsList()

    fun insertItems(items: List<ListItem>) {
        database.listBazaQueries.transaction {
            items.forEach { item ->
                insertItem(item)
            }
        }
    }

    private fun insertItem(item: ListItem) {
        database.listBazaQueries.insertItem(
            list_id = item.list_id,
            name = item.name,
            quantity = item.quantity,
            created_at = item.created_at.toString()
        )
    }

    fun updateItems(items: List<ListItem>) {
        database.listBazaQueries.transaction {
            items.forEach { item ->
                updateItem(item)
            }
        }
    }

    private fun updateItem(item: ListItem) {
        database.listBazaQueries.updateItem(
            list_id = item.list_id,
            name = item.name,
            quantity = item.quantity,
            created_at = item.created_at.toString(),
            id = item.id
        )
    }

    fun deleteItem(id: Long) {
        database.listBazaQueries.deleteItem(id)
    }

}

