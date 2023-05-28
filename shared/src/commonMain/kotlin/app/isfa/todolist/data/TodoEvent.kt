package app.isfa.todolist.data

sealed class TodoEvent {
    class Add(val todo: Todo) : TodoEvent()
    class Remove(val todo: Todo) : TodoEvent()
}