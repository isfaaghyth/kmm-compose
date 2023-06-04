package app.isfa.todolist.ui.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import app.isfa.todolist.utils.Dialog

@Composable
internal fun TodoDialog(
    text: String = "",
    onCloseClicked: () -> Unit,
    onTextChanged: (String) -> Unit
) {
    Dialog(
        title = "Edit TODO",
        onCloseRequest = onCloseClicked,
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            TextField(
                value = text,
                modifier = Modifier
                    .weight(1F)
                    .fillMaxWidth()
                    .sizeIn(minHeight = 192.dp),
                label = { Text("Todo text") },
                onValueChange = onTextChanged,
            )

            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}