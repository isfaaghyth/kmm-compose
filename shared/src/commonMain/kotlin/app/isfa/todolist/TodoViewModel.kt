package app.isfa.todolist

import app.isfa.todolist.effects.TodoEffectHandler
import app.isfa.todolist.event.TodoEvent
import app.isfa.todolist.event.TodoUpdate
import app.isfa.todolist.ui.model.TodoModel
import app.isfa.todolist.ui.model.TodoState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kt.mobius.flow.FlowMobius
import kotlin.coroutines.CoroutineContext

class TodoViewModel constructor(
    effectHandler: TodoEffectHandler,
    eventUpdate: TodoUpdate,
) : TodoViewModelContract, CoroutineScope {

    override val coroutineContext: CoroutineContext
        get() = Job() + Dispatchers.Main

    override val loop = FlowMobius.loop(
        eventUpdate,
        effectHandler.create()
    )

    override val model: StateFlow<TodoModel>
        get() = _model

    private val _loop = loop.startFrom(
        TodoModel(state = TodoState.EMPTY)
    )

    private val _model = MutableStateFlow(
        _loop.mostRecentModel
    )

    init {
        _loop.observe { model ->
            _model.value = model
        }
    }

    override fun setAction(action: TodoEvent) {
        _loop.dispatchEvent(action)
    }
}