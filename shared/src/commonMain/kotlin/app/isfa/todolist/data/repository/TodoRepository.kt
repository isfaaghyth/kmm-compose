package app.isfa.todolist.data.repository

import app.isfa.todolist.data.TodoState
import app.isfa.todolist.data.entity.Todo
import com.benasher44.uuid.Uuid
import com.benasher44.uuid.uuid4
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.datetime.Clock

interface TodoRepository {
    val state: StateFlow<TodoState>

    fun add(text: String)
    fun remove(uuid: Uuid)
    fun onShowAddDialog(show: Boolean)
}

class TodoRepositoryImpl : TodoRepository {

    override val state: StateFlow<TodoState>
        get() = _state

    private val _state = MutableStateFlow(TodoState())

    override fun add(text: String) {
        _state.value = state.value.copy()
            .also {
                it.list.add(
                    Todo(
                        uuid = uuid4(),
                        text = text,
                        createdAt = Clock
                            .System
                            .now()
                            .epochSeconds
                    )
                )
            }
    }

    override fun remove(uuid: Uuid) {
        _state.value = state.value.copy()
            .also { state ->
                val list = state.list

                val todo = list.find { it.uuid == uuid } ?: return
                val index = list.indexOf(todo)

                if (index > -1) {
                    list.removeAt(index)
                }
            }
    }

    override fun onShowAddDialog(show: Boolean) {
        _state.value = state.value.copy(
            isTodoAdd = show
        )
    }
}