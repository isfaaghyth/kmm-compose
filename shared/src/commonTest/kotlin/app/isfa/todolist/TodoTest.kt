package app.isfa.todolist

import androidx.compose.runtime.mutableStateListOf
import app.isfa.todolist.data.entity.Todo
import app.isfa.todolist.effects.IsFeatureEnabled
import app.isfa.todolist.event.FeatureDisabled
import app.isfa.todolist.event.FeatureEnabled
import app.isfa.todolist.event.GetTodo
import app.isfa.todolist.event.TodoFetched
import app.isfa.todolist.event.TodoUpdate
import app.isfa.todolist.ui.model.TodoModel
import app.isfa.todolist.ui.model.TodoState
import com.benasher44.uuid.uuid4
import kotlinx.datetime.Clock
import kt.mobius.test.NextMatchers.hasEffects
import kt.mobius.test.NextMatchers.hasModel
import kt.mobius.test.UpdateSpec
import kt.mobius.test.UpdateSpec.Companion.assertThatNext
import kotlin.test.Test

class TodoTest {

    private val update = TodoUpdate()

    @Test
    fun when_GetTodo_event_triggered_then_IsFeatureEnabled_dispatched() {
        val model = TodoModel(state = TodoState.EMPTY)

        UpdateSpec(update)
            .given(model)
            .whenEvent(GetTodo)
            .then(assertThatNext(
                hasEffects(IsFeatureEnabled)
            ))
    }

    @Test
    fun when_TodoFetched_event_triggered_then_has_model() {
        val model = TodoModel(state = TodoState.EMPTY)

        UpdateSpec(update)
            .given(model)
            .whenEvent(TodoFetched(
                mutableStateListOf(mockModel)
            ))
            .then(assertThatNext(
                hasModel()
            ))
    }

    @Test
    fun when_has_FeatureEnabled_then_state_change_to_Loading() {
        val model = TodoModel(state = TodoState.EMPTY)

        UpdateSpec(update)
            .given(model)
            .whenEvent(FeatureEnabled)
            .then(assertThatNext(
                hasModel()
            ))
    }

    @Test
    fun when_has_FeatureDisabled_then_state_change_to_Disabled() {
        val model = TodoModel(state = TodoState.EMPTY)

        UpdateSpec(update)
            .given(model)
            .whenEvent(FeatureDisabled)
            .then(assertThatNext(
                hasModel()
            ))
    }

    companion object {
        val mockModel = Todo(
            uuid = uuid4(),
            text = "Ipsum",
            createdAt = Clock
                .System
                .now()
                .epochSeconds
        )
    }
}