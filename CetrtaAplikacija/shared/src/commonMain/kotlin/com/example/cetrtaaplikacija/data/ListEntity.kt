package data

import kotlinx.datetime.LocalDateTime

data class ListEntity(
    val id: Long? = null,
    val title: String,
    val created_at: LocalDateTime
)
