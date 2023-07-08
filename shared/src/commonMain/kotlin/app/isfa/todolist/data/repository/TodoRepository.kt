package app.isfa.todolist.data.repository

import app.isfa.todolist.data.entity.Todo
import com.benasher44.uuid.Uuid
import com.benasher44.uuid.uuid4
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.datetime.Clock

interface TodoRepository {

    fun getTodoList(): Flow<List<Todo>>
    fun insertTodo(content: String)
    fun deleteTodo(uuid: Uuid)
}

class TodoRepositoryImpl : TodoRepository {

    private val data = mutableListOf(
        Todo(
            uuid = uuid4(),
            text = "Foo",
            createdAt = Clock
                .System
                .now()
                .epochSeconds
        ),
        Todo(
            uuid = uuid4(),
            text = "Bar",
            createdAt = Clock
                .System
                .now()
                .epochSeconds
        ),
        Todo(
            uuid = uuid4(),
            text = "Loren",
            createdAt = Clock
                .System
                .now()
                .epochSeconds
        ),
        Todo(
            uuid = uuid4(),
            text = "Ipsum",
            createdAt = Clock
                .System
                .now()
                .epochSeconds
        )
    )

    override fun getTodoList(): Flow<List<Todo>> {
        return flow {
            emit(data)
        }
    }

    override fun insertTodo(content: String) {

    }

    override fun deleteTodo(uuid: Uuid) {

    }
}