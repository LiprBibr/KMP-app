package data

import kotlinx.datetime.LocalDateTime

data class ListItem(
    val id: Long? = null,
    val listId: Long,
    val name: String,
    val quantity: Int = 1,
    val createdAt: LocalDateTime
)
