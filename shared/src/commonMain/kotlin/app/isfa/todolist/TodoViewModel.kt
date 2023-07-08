package app.isfa.todolist

import app.isfa.todolist.data.model.TodoModel
import app.isfa.todolist.data.model.TodoState
import app.isfa.todolist.data.repository.FeatureToggleRepository
import app.isfa.todolist.data.repository.TodoRepository
import app.isfa.todolist.effects.TodoEffectHandler
import app.isfa.todolist.event.TodoEvent
import app.isfa.todolist.event.TodoUpdate
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kt.mobius.flow.FlowMobius
import kt.mobius.functions.Consumer
import kotlin.coroutines.CoroutineContext

class TodoViewModel constructor(
    todoRepository: TodoRepository,
    featureToggle: FeatureToggleRepository,
) : TodoViewModelContract, CoroutineScope {

    override val coroutineContext: CoroutineContext
        get() = Job() + Dispatchers.Main

    override val loop = FlowMobius.loop(
        TodoUpdate(),
        TodoEffectHandler(
            todoRepository,
            featureToggle
        ).create()
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