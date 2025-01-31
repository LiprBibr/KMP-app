package com.example.cetrtaaplikacija.di

import app.cash.sqldelight.db.SqlDriver
import com.example.cetrtaaplikacija.db.DatabaseDriverFactory
import org.koin.dsl.module
import baza.list.db.ListBaza

val databaseModule = module {
    single<SqlDriver> {DatabaseDriverFactory().createDriver()}

    single<ListBaza> { ListBaza(get()) }
}