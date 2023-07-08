package app.isfa.todolist.event

import app.isfa.todolist.data.entity.Todo

sealed class TodoEvent

// user interaction
object GetTodo : TodoEvent()

// effect feedback
object FeatureEnabled : TodoEvent()
object FeatureDisabled : TodoEvent()
data class TodoFetched(val data: List<Todo>) : TodoEvent()