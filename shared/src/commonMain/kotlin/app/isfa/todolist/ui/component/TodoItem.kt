package app.isfa.todolist.ui.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun TodoItem(modifier: Modifier = Modifier, content: String) {
    Row(
        modifier = modifier
            .border(
                border = BorderStroke(0.5.dp, Color.Gray),
                shape = RoundedCornerShape(4.dp)
            )
            .fillMaxWidth()
            .background(
                color = Color.White,
                shape = RoundedCornerShape(4.dp)
            )
            .padding(8.dp),
    ) {
        Text(
            text = content,
            style = MaterialTheme.typography.body2
        )
    }
}