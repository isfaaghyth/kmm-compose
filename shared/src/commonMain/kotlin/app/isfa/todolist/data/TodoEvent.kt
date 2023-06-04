package app.isfa.todolist.data

import com.benasher44.uuid.Uuid

/**
 * [TodoEvent] represent as event action that received from user.
 * every single event will be observed and trigger the [TodoState].
 *
 * [TodoEvent] contains:
 * 1. Add
 * 2. Remove
 *
 * Which the event only available for add and remove the data.
 */
sealed class TodoEvent {
    object Add : TodoEvent()
    class Save(val text: String) : TodoEvent()
    class Remove(val uuid: Uuid) : TodoEvent()
}