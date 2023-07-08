package app.isfa.todolist.event

import androidx.compose.runtime.snapshots.SnapshotStateList
import app.isfa.todolist.data.entity.Todo

sealed class TodoEvent

// user interaction
object GetTodo : TodoEvent()
data class AddTodoClicked(val content: String) : TodoEvent()

// effect feedback
object FeatureEnabled : TodoEvent()
object FeatureDisabled : TodoEvent()
data class TodoFetched(val data: SnapshotStateList<Todo>) : TodoEvent()