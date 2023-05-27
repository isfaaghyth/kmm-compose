@file:OptIn(ExperimentalResourceApi::class)

package app.isfa.todolist.ui

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import app.isfa.todolist.getPlatform
import org.jetbrains.compose.resources.ExperimentalResourceApi

@Composable
fun TodoAppContent() {
    var greetingText by remember { mutableStateOf("Hello, World!") }
    var showImage by remember { mutableStateOf(false) }

    Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
        Button(onClick = {
            greetingText = "Hello, ${getPlatform().name}"
            showImage = !showImage
        }) {
            Text(greetingText)
        }
        AnimatedVisibility(showImage) {
            Text("oh hi! you're at $showImage state now!")
        }
    }
}