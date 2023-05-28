package app.isfa.todolist.data

data class TodoState(
    val list: MutableList<Todo> = mutableListOf()
) {

    fun add(item: Todo) {
        list.add(item)
    }

    fun remove(item: Todo) {
        val todo = list.find { it.text == item.text } ?: return
        val index = list.indexOf(todo)

        if (index > -1) {
            list.removeAt(index)
        }
    }
}