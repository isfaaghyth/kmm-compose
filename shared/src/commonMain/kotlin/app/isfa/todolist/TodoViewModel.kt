package app.isfa.todolist

import app.isfa.todolist.data.TodoEvent
import app.isfa.todolist.data.TodoState
import app.isfa.todolist.data.repository.TodoRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class TodoViewModel constructor(
    private val repository: TodoRepository
) : TodoViewModelContract, CoroutineScope {

    override val coroutineContext: CoroutineContext
        get() = Job() + Dispatchers.Main

    override val state: StateFlow<TodoState>
        get() = repository.state

    private val _event = MutableSharedFlow<TodoEvent>(replay = 50)

    init {
        launch {
            _event
                .distinctUntilChanged()
                .collect { event ->
                    when (event) {
                        is TodoEvent.Add -> repository.add(event.text)
                        is TodoEvent.Remove -> repository.remove(event.uuid)
                    }
                }
        }
    }

    override fun setAction(action: TodoEvent) {
        _event.tryEmit(action)
    }
}