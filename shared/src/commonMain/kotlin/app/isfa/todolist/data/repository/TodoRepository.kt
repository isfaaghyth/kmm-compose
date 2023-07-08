package app.isfa.todolist.data.repository

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import app.isfa.todolist.data.entity.Todo
import app.isfa.todolist.util.currentTime
import com.benasher44.uuid.Uuid
import com.benasher44.uuid.uuid4
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.datetime.Clock

interface TodoRepository {

    fun getTodoList(): Flow<SnapshotStateList<Todo>>
    fun insertTodo(content: String)
    fun deleteTodo(uuid: Uuid)
}

class TodoRepositoryImpl : TodoRepository {

    private val data = mutableStateListOf<Todo>()

    init {
        data.addAll(sampleData)
    }

    override fun getTodoList(): Flow<SnapshotStateList<Todo>> {
        return flow {
            emit(data)
        }
    }

    override fun insertTodo(content: String) {
        data.add(0, createTodoModel(content))
    }

    override fun deleteTodo(uuid: Uuid) {

    }

    private fun createTodoModel(content: String) =
        Todo(
            uuid4(),
            content,
            currentTime()
        )
}