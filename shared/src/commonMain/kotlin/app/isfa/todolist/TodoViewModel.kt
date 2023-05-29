package app.isfa.todolist

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import app.isfa.todolist.data.TodoEvent
import app.isfa.todolist.data.TodoState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class TodoViewModel : TodoViewModelContract, CoroutineScope {

    override val coroutineContext: CoroutineContext
        get() = Job() + Dispatchers.Main

    override val state: State<TodoState>
        get() = _state

    private val _event = MutableSharedFlow<TodoEvent>(replay = 50)
    private val _state = mutableStateOf(TodoState())

    init {
        launch {
            _event
                .distinctUntilChanged()
                .collect { event ->
                    when (event) {
                        is TodoEvent.Add -> {
                            _state.value = state.value.copy()
                                .also {
                                    it.add(event.todo)
                                }
                        }
                        is TodoEvent.Remove -> {
                            _state.value = state.value.copy()
                                .also {
                                    it.remove(event.todo)
                                }
                        }
                    }
                }
        }
    }

    override fun setAction(action: TodoEvent) {
        _event.tryEmit(action)
    }
}