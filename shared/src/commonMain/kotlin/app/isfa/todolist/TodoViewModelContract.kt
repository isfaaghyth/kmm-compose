package app.isfa.todolist

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import app.isfa.todolist.data.Todo
import app.isfa.todolist.data.TodoEvent
import app.isfa.todolist.data.TodoState

interface TodoViewModelContract {
    val state: State<TodoState>

    fun setAction(action: TodoEvent)

    companion object {
        fun mock(): TodoViewModelContract {
            return object : TodoViewModelContract {
                override val state: State<TodoState>
                    get() = mutableStateOf(TodoState(
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