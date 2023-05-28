package app.isfa.todolist.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import app.isfa.todolist.TodoViewModelContract
import app.isfa.todolist.data.Todo
import app.isfa.todolist.data.TodoEvent
import app.isfa.todolist.data.TodoState
import app.isfa.todolist.getPlatform
import app.isfa.todolist.ui.component.TodoItem

@Composable
fun TodoAppContent(viewModel: TodoViewModelContract = TodoViewModelContract.empty()) {
    var platformName by remember { mutableStateOf("+") }
    val state by viewModel.state.collectAsState(
        initial = TodoState()
    )

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
        ) {
            items(state.list) {
                TodoItem(title = it.text)
            }
        }

        Button(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(10.dp),
            shape = RoundedCornerShape(100),
            onClick = {
                platformName = "+ (${getPlatform().name})"
                viewModel.setAction(
                    TodoEvent.Add(
                        Todo("random: ${(1..9).random()}")
                    )
                )
            }
        ) {
            Text(platformName)
        }
    }
}