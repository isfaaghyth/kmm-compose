package app.isfa.todolist.di

import app.isfa.todolist.TodoViewModel
import org.koin.dsl.module

val viewModelModule = module {
    single { TodoViewModel(get()) }
}