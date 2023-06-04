package app.isfa.todolist.ui.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import app.isfa.todolist.utils.Dialog

@Composable
internal fun TodoDialog(
    onCloseClicked: () -> Unit,
    onTextChanged: (String) -> Unit
) {
    var text by remember { mutableStateOf("") }

    Dialog(
        title = "Add Todo",
        onCloseRequest = onCloseClicked,
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            TextField(
                value = text,
                modifier = Modifier
                    .weight(1F)
                    .fillMaxWidth()
                    .sizeIn(minHeight = 56.dp),
                label = { Text("Please write your todo here...") },
                onValueChange = {
                    text = it
                    onTextChanged(it)
                },
            )

            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}