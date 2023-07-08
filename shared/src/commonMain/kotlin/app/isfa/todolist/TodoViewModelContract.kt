package app.isfa.todolist

import app.isfa.todolist.data.model.TodoModel
import app.isfa.todolist.data.model.TodoState
import app.isfa.todolist.effects.TodoEffect
import app.isfa.todolist.event.TodoEvent
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kt.mobius.MobiusLoop

interface TodoViewModelContract {

    val model: StateFlow<TodoModel>

    val loop: MobiusLoop.Builder<
            TodoModel,
            TodoEvent,
            TodoEffect>?

    fun setAction(action: TodoEvent)

    companion object {
        fun mock(): TodoViewModelContract {
            return object : TodoViewModelContract {
                override val loop: MobiusLoop.Builder<TodoModel, TodoEvent, TodoEffect>?
                    get() = null

                override val model: StateFlow<TodoModel>
                    get() = MutableStateFlow(TodoModel(state = TodoState.EMPTY))

                override fun setAction(action: TodoEvent) = Unit
            }
        }
    }
}