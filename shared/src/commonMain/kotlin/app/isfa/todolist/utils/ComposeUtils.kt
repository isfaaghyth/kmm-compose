package app.isfa.todolist.utils

import androidx.compose.runtime.Composable

@Composable
internal expect fun Dialog(
    title: String,
    onCloseRequest: () -> Unit,
    content: @Composable () -> Unit
)