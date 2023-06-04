package app.isfa.todolist

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import app.isfa.todolist.data.TodoEvent
import app.isfa.todolist.ui.ShowAddDialog
import app.isfa.todolist.ui.TodoAppContent

@Composable
fun TodoApp(viewModel: TodoViewModelContract = TodoViewModelContract.mock()) {
    val state by viewModel.state.collectAsState()

    MaterialTheme {
        ShowAddDialog(
            state = state,
            onCloseClicked = {
                viewModel.setAction(TodoEvent.Save(it))
            }
        )

        TodoAppContent(
            state = state,
            onRemoveClicked = {
                viewModel.setAction(TodoEvent.Remove(it))
            },
            onAddClicked = {
                viewModel.setAction(TodoEvent.Add)
            }
        )
    }
}