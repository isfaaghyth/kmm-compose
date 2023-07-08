package app.isfa.todolist

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import app.isfa.todolist.event.GetTodo
import app.isfa.todolist.ui.TodoAppContent

@Composable
fun TodoApp(viewModel: TodoViewModelContract = TodoViewModelContract.mock()) {
    val model by viewModel.model.collectAsState()

    // initial state
    LaunchedEffect(Unit) {
        viewModel.setAction(GetTodo)
    }

    MaterialTheme {
        TodoAppContent(
            model = model,
            onRemoveClicked = {

            },
            onAddClicked = {

            }
        )
    }
}