package app.isfa.todolist.event

import app.isfa.todolist.effects.FetchTodo
import app.isfa.todolist.effects.IsFeatureEnabled
import app.isfa.todolist.effects.TodoEffect
import app.isfa.todolist.ui.model.TodoModel
import app.isfa.todolist.ui.model.TodoState
import kt.mobius.Next
import kt.mobius.Next.Companion.dispatch
import kt.mobius.Next.Companion.next
import kt.mobius.Update

class TodoUpdate : Update<TodoModel, TodoEvent, TodoEffect> {

    override fun update(
        model: TodoModel,
        event: TodoEvent
    ): Next<TodoModel, TodoEffect> {
        return when (event) {
            is GetTodo -> dispatch(
                setOf(IsFeatureEnabled)
            )
            is FeatureDisabled -> next(
                TodoModel(state = TodoState.DISABLED)
            )
            is FeatureEnabled -> next(
                model.copy(state = TodoState.LOADING),
                setOf(FetchTodo)
            )
            is TodoFetched -> next(
                model.copy(
                    state = TodoState.SUCCESS,
                    data = event.data
                )
            )
        }
    }
}