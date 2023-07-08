package app.isfa.todolist.effects

sealed class TodoEffect

object IsFeatureEnabled : TodoEffect()
object FetchTodo : TodoEffect()
data class AddTodo(val content: String) : TodoEffect()