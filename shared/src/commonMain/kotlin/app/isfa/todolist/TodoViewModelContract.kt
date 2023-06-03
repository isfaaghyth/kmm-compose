package app.isfa.todolist

import androidx.compose.runtime.mutableStateListOf
import app.isfa.todolist.data.TodoEvent
import app.isfa.todolist.data.TodoState
import app.isfa.todolist.data.entity.Todo
import com.benasher44.uuid.uuid4
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

interface TodoViewModelContract {
    val state: StateFlow<TodoState>

    fun setAction(action: TodoEvent)

    companion object {
        fun mock(): TodoViewModelContract {
            return object : TodoViewModelContract {
                override val state: StateFlow<TodoState>
                    get() = MutableStateFlow(TodoState(
                        list = mutableStateListOf(
                            Todo(uuid4(), "Foo", 0),
                            Todo(uuid4(), "Bar", 0),
                            Todo(uuid4(), "Loren", 0),
                            Todo(uuid4(), "Ipsum", 0),
                            Todo(uuid4(), "Barbara", 0)
                        )
                    ))

                override fun setAction(action: TodoEvent) = Unit
            }
        }
    }
}