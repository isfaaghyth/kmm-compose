package app.isfa.todolist.utils

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.ProvideTextStyle
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
internal actual fun Dialog(
    title: String,
    onCloseRequest: () -> Unit,
    content: @Composable () -> Unit
) {
    Box(
        Modifier
            .fillMaxSize()
            .background(Color.Black.copy(alpha = 0.4f))
            .clickable {
                onCloseRequest()
            }
    ) {
        Box(
            Modifier
                .padding(30.dp)
                .background(Color.White)
                .align(Alignment.TopCenter)
                .clickable(enabled = false){}
        ) {
            Column(
                modifier = Modifier.padding(8.dp)
            ) {
                ProvideTextStyle(MaterialTheme.typography.subtitle1) {
                    Text(text = title)
                }

                Spacer(modifier = Modifier.height(8.dp))

                Box(modifier = Modifier.fillMaxHeight(0.5f)) {
                    content()
                }

                Spacer(modifier = Modifier.height(8.dp))

                Button(
                    onClick = onCloseRequest,
                    modifier = Modifier.align(Alignment.End)
                ) {
                    Text(text = "Done")
                }
            }
        }
    }
}