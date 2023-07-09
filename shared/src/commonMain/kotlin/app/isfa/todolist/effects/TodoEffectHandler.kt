package app.isfa.todolist.effects

import app.isfa.todolist.data.repository.FeatureToggleRepository
import app.isfa.todolist.data.repository.TodoRepository
import app.isfa.todolist.event.FeatureDisabled
import app.isfa.todolist.event.FeatureEnabled
import app.isfa.todolist.event.TodoEvent
import app.isfa.todolist.event.TodoFetched
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flatMapMerge
import kotlinx.coroutines.flow.map
import kt.mobius.flow.subtypeEffectHandler

class TodoEffectHandler constructor(
    private val todoRepository: TodoRepository,
    private val featureToggle: FeatureToggleRepository,
) {

    fun create() = subtypeEffectHandler {
        // feature toggle
        addFunction<IsFeatureEnabled> { featureToggle() }

        // Transform Effect to Event
        addTransformer<FetchTodo> {
            it.flatMapMerge {
                fetchTodoList()
            }
        }
    }

    private fun fetchTodoList(): Flow<TodoEvent> {
        return todoRepository.getTodoList().map {
            TodoFetched(it)
        }
    }

    private fun featureToggle(): TodoEvent {
        return if (featureToggle.isEnabled()) {
            FeatureEnabled
        } else {
            FeatureDisabled
        }
    }
}