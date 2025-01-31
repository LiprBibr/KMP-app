package com.example.cetrtaaplikacija.android.di

import app.cash.sqldelight.db.SqlDriver
import com.example.cetrtaaplikacija.db.DatabaseDriverFactory
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import baza.list.db.ListBaza

val databaseModule = module {
    single<SqlDriver> { DatabaseDriverFactory(androidContext()).createDriver()}

    single<ListBaza> {ListBaza(get()) }
}