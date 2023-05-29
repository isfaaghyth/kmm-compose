package app.isfa.todolist

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import app.isfa.todolist.ui.TodoAppContent

@Composable
fun TodoApp(viewModel: TodoViewModelContract = TodoViewModelContract.mock()) {
    MaterialTheme {
        TodoAppContent(viewModel)
    }
}