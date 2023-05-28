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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import app.isfa.todolist.getPlatform
import app.isfa.todolist.ui.component.TodoItem

@Composable
fun TodoAppContent() {
    var greetingText by remember { mutableStateOf("+") }

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
        ) {
            items(listOf("Foo", "Bar","Loren", "Ipsum")) {
                TodoItem(title = it)
            }
        }

        Button(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(10.dp),
            shape = RoundedCornerShape(100),
            onClick = {
                greetingText = "+ (${getPlatform().name})"
            }
        ) {
            Text(greetingText)
        }
    }
}