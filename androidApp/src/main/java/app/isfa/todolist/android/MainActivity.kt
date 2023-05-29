package app.isfa.todolist.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import app.isfa.todolist.TodoApp
import app.isfa.todolist.TodoViewModel

class MainActivity : ComponentActivity() {

    private val viewModel = TodoViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TodoApp(viewModel)
        }
    }
}

@Preview
@Composable
fun DefaultPreview() {
    TodoApp()
}