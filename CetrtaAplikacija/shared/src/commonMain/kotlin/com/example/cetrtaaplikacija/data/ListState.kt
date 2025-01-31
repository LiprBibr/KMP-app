package com.example.cetrtaaplikacija.data

import data.ListEntity

data class ListState(
    val lists: List<ListEntity> = listOf(),
    val loading: Boolean = false,
    val error: String? = null
)
