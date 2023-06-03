package app.isfa.todolist.data

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import app.isfa.todolist.data.entity.Todo

data class TodoState(
    val list: SnapshotStateList<Todo> = mutableStateListOf()
)