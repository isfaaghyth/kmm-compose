package app.isfa.todolist.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.DismissDirection
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.FractionalThreshold
import androidx.compose.material.SwipeToDismiss
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.rememberDismissState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import app.isfa.todolist.data.TodoState
import app.isfa.todolist.getPlatform
import app.isfa.todolist.ui.component.TodoDialog
import app.isfa.todolist.ui.component.TodoItem
import com.benasher44.uuid.Uuid

@Composable
fun ShowAddDialog(
    state: TodoState,
    onCloseClicked: (String) -> Unit
) {
    var onAddTextChanged by remember { mutableStateOf("") }

    state.isTodoAdd.also { isShown ->
        if (isShown) {
            TodoDialog(
                onCloseClicked = {
                    onCloseClicked(onAddTextChanged)
                    onAddTextChanged = ""
                },
                onTextChanged = {
                    onAddTextChanged = it
                }
            )
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun TodoList(
    state: TodoState,
    onDismissSwiped: (Uuid) -> Unit
) {
    val listState = rememberLazyListState()

    LazyColumn(
        state = listState,
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(
            items = state.list,
            key = { item ->
                item.uuid.mostSignificantBits
            }
        ) {
            val dismissState = rememberDismissState()

            if (dismissState.isDismissed(DismissDirection.EndToStart)) {
                onDismissSwiped(it.uuid)
            }

            SwipeToDismiss(
                state = dismissState,
                directions = setOf(DismissDirection.EndToStart),
                dismissThresholds = { direction ->
                    FractionalThreshold(
                        if (direction == DismissDirection.StartToEnd) 0.25f else 0.5f
                    )
                },
                background = {},
                dismissContent = {
                    TodoItem(title = it.text)
                }
            )
        }
    }
}

@Composable
fun TodoAppContent(
    state: TodoState,
    onRemoveClicked: (Uuid) -> Unit,
    onAddClicked: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        TopAppBar(title = { Text(text = "TODO-app at ${getPlatform().name}!") })

        Box(modifier = Modifier.fillMaxSize()) {
            TodoList(
                state = state,
                onDismissSwiped = { onRemoveClicked(it) }
            )

            Button(
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(10.dp),
                shape = RoundedCornerShape(100),
                onClick = { onAddClicked() }
            ) {
                Text("+")
            }
        }
    }
}