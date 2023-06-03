package app.isfa.todolist.data.entity

import com.benasher44.uuid.Uuid

data class Todo(
    val uuid: Uuid,
    val text: String,
    val createdAt: Long
)