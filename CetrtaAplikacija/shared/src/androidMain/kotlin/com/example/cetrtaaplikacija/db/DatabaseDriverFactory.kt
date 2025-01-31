package com.example.cetrtaaplikacija.db

import android.content.Context
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.android.AndroidSqliteDriver
import baza.list.db.ListBaza

actual class DatabaseDriverFactory(private val context: Context) {

    actual fun createDriver(): SqlDriver =
        AndroidSqliteDriver(
            schema = ListBaza.Schema,
            context = context,
            name = "baza.list.db"
        )
}