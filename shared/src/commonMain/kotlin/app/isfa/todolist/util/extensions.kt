package app.isfa.todolist.util

import kotlinx.datetime.Clock

fun currentTime(): Long {
    return Clock
        .System
        .now()
        .epochSeconds
}