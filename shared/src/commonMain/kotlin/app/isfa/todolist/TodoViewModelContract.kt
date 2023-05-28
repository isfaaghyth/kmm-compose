package app.isfa.todolist

import app.isfa.todolist.data.Todo
import app.isfa.todolist.data.TodoEvent
import app.isfa.todolist.data.TodoState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow

interface TodoViewModelContract {
    val state: Flow<TodoState>

    fun setAction(action: TodoEvent)

    companion object {
        fun empty(): TodoViewModelContract {
            return object : TodoViewModelContract {
                override val state: Flow<TodoState>
                    get() = MutableStateFlow(TodoState(
                        list = mutableListOf(
                            Todo("Foo"),
                            Todo("Bar"),
                            Todo("Loren"),
                            Todo("Ipsum"),
                            Todo("Barbara")
                        )
                    ))

                override fun setAction(action: TodoEvent) = Unit
            }
        }
    }
}