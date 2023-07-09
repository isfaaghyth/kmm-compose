package app.isfa.todolist.di

import app.isfa.todolist.data.repository.FeatureToggleRepository
import app.isfa.todolist.data.repository.FeatureToggleRepositoryImpl
import app.isfa.todolist.data.repository.TodoRepository
import app.isfa.todolist.data.repository.TodoRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {
    single<TodoRepository> { TodoRepositoryImpl() }
    single<FeatureToggleRepository> { FeatureToggleRepositoryImpl() }
}