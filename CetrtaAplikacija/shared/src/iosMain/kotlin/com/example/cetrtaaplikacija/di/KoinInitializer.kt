package com.example.cetrtaaplikacija

import com.example.cetrtaaplikacija.presentation.ListViewModel
import com.example.cetrtaaplikacija.di.databaseModule
import com.example.cetrtaaplikacija.data.di.ListModule
import org.koin.core.context.startKoin
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import com.example.cetrtaaplikacija.di.sharedKoinModules

fun initKoin() {
    val modules = sharedKoinModules + databaseModule + ListModule

    startKoin {
        modules(modules)
    }
}

class ListInjector : KoinComponent {
    val listViewModel: ListViewModel by inject()
}
