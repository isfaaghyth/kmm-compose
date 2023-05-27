package app.isfa.todolist

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform