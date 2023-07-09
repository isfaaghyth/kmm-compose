package app.isfa.todolist.ui.model

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import app.isfa.todolist.data.entity.Todo

enum class TodoState {
    EMPTY, LOADING, SUCCESS, DISABLED
}

data class TodoModel(
    val state: TodoState,
    val data: SnapshotStateList<Todo> = mutableStateListOf()
)