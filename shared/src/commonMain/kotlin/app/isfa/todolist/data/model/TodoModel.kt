package app.isfa.todolist.data.model

import app.isfa.todolist.data.entity.Todo

enum class TodoState {
    EMPTY, LOADING, SUCCESS, DISABLED
}

data class TodoModel(
    val state: TodoState,
    val data: List<Todo> = emptyList()
)