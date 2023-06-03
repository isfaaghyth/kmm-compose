import app.isfa.todolist.TodoViewModel
import app.isfa.todolist.di.appModule
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.context.startKoin

class AppDiHelper : KoinComponent {

    private val viewModel: TodoViewModel by inject()

    fun viewModel() = viewModel
}

fun initKoin() {
    startKoin {
        modules(appModule)
    }
}