package com.example.cetrtaaplikacija.data.di

import  org.koin.dsl.module
import com.example.cetrtaaplikacija.data.ListRepository
import com.example.cetrtaaplikacija.data.ItemRepository
import com.example.cetrtaaplikacija.data.LocalDataSource
import com.example.cetrtaaplikacija.domain.usecase.ListUseCase
import com.example.cetrtaaplikacija.presentation.ListViewModel


val ListModule = module {

    single { LocalDataSource(get()) }

    single { ListRepository(get()) }

    single { ItemRepository(get()) }

    single { ListUseCase(get(), get()) }

    single { ListViewModel() }

}