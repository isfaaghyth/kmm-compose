package app.isfa.todolist.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp

@Composable
fun AddTodoBottomSheet(onSaveClicked: (String) -> Unit) {
    var content by remember { mutableStateOf(TextFieldValue("")) }
    val focusManager = LocalFocusManager.current

    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        TextField(
            value = content,
            onValueChange = { content = it },
            label = {
                Text(text = "Insert a new Todo here")
            },
            colors = TextFieldDefaults.textFieldColors(
                disabledTextColor = Color.Transparent,
                backgroundColor = Color.White,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent
            ),
            modifier = Modifier
                .fillMaxWidth()
                .border(
                    border = BorderStroke(0.5.dp, Color.Gray),
                    shape = RoundedCornerShape(4.dp)
                )
        )

        Spacer(modifier = Modifier.height(8.dp))

        Button(
            onClick = {
                onSaveClicked(content.text)

                // TODO: Platformized the BackHandle gesture
                focusManager.clearFocus()
                content = TextFieldValue("")
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Add Todo")
        }
    }
}