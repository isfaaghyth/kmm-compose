package app.isfa.todolist.di

import app.isfa.todolist.effects.TodoEffectHandler
import app.isfa.todolist.event.TodoUpdate
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val mobiusModule = module {
    singleOf(::TodoEffectHandler)
    singleOf(::TodoUpdate)
}