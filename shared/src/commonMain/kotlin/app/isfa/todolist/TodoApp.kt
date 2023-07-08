package app.isfa.todolist

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import app.isfa.todolist.event.AddTodoClicked
import app.isfa.todolist.event.GetTodo
import app.isfa.todolist.ui.AddTodoBottomSheet
import app.isfa.todolist.ui.TodoAppContent
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun TodoApp(viewModel: TodoViewModelContract = TodoViewModelContract.mock()) {
    val model by viewModel.model.collectAsState()
    val coroutineScope = rememberCoroutineScope()

    val sheetState = rememberModalBottomSheetState(
        initialValue = ModalBottomSheetValue.Hidden,
        confirmValueChange = { it != ModalBottomSheetValue.HalfExpanded }
    )

    // initial state
    LaunchedEffect(Unit) {
        viewModel.setAction(GetTodo)
    }

    MaterialTheme {
        ModalBottomSheetLayout(
            sheetState = sheetState,
            sheetContent = {
                AddTodoBottomSheet {
                    // hide bottom sheet
                    coroutineScope.launch { sheetState.hide() }

                    // add data
                    viewModel.setAction(AddTodoClicked(it))
                }
            },
            modifier = Modifier.fillMaxSize()
        ) {
            TodoAppContent(
                model = model,
                onRemoveClicked = {

                },
                onAddClicked = {
                    coroutineScope.launch {
                        if (sheetState.isVisible.not()) {
                            sheetState.show()
                        } else {
                            sheetState.hide()
                        }
                    }
                }
            )
        }
    }
}