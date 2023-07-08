package app.isfa.todolist.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun AddTodoBottomSheet(onSaveClicked: (String) -> Unit) {
    Column(
        modifier = Modifier.padding(32.dp)
    ) {
        Text(
            text = "Bottom sheet",
            style = MaterialTheme.typography.h6
        )

        Spacer(modifier = Modifier.height(32.dp))

        Button(
            onClick = {
                onSaveClicked("todo rand: ${(1..9).random()}")
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Add Todo")
        }
    }
}