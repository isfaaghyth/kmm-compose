package app.isfa.todolist.data.repository

import app.isfa.todolist.data.entity.Todo
import app.isfa.todolist.util.currentTime
import com.benasher44.uuid.uuid4

val sampleData = listOf(
    Todo(
        uuid = uuid4(),
        text = "Foo",
        createdAt = currentTime()
    ),
    Todo(
        uuid = uuid4(),
        text = "Bar",
        createdAt = currentTime()
    ),
    Todo(
        uuid = uuid4(),
        text = "Loren",
        createdAt = currentTime()
    ),
    Todo(
        uuid = uuid4(),
        text = "Ipsum",
        createdAt = currentTime()
    )
)