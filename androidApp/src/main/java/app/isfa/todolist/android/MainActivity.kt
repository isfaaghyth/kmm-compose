package app.isfa.todolist.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import app.isfa.todolist.TodoApp
import app.isfa.todolist.TodoViewModel
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class MainActivity : ComponentActivity(), KoinComponent {

    private val viewModel: TodoViewModel by inject()

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