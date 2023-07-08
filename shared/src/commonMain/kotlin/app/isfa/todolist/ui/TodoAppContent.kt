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
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import app.isfa.todolist.data.model.TodoModel
import app.isfa.todolist.getPlatform
import app.isfa.todolist.ui.component.TodoItem
import com.benasher44.uuid.Uuid

@Composable
fun TodoAppContent(
    model: TodoModel,
    onRemoveClicked: (Uuid) -> Unit,
    onAddClicked: () -> Unit
) {
    val listState = rememberLazyListState()

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        TopAppBar(title = { Text(text = "todo-app: @${getPlatform().name}!") })

        Box(modifier = Modifier.fillMaxSize()) {
            LazyColumn(
                state = listState,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(
                    items = model.data,
                    key = { item ->
                        item.uuid.mostSignificantBits
                    }
                ) {
                    TodoItem(content = it.text)
                }
            }

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
