package app.isfa.todolist.data

import app.isfa.todolist.Platform
import app.isfa.todolist.getPlatform

class Greeting {
    private val platform: Platform = getPlatform()

    fun greet(): String {
        return "Hello, ${platform.name}!"
    }
}