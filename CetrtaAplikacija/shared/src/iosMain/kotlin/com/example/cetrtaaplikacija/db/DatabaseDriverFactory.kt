package com.example.cetrtaaplikacija.db

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.native.NativeSqliteDriver
import baza.list.db.ListBaza

actual class DatabaseDriverFactory() {
    actual fun createDriver(): SqlDriver =
        NativeSqliteDriver(
            schema = ListBaza.Schema,
            name = "baza.list.db"
        )
}