object Navigator {
    fun <T> navigate(
        title: String,
        list: MutableList<T>,
        onSelect: (T) -> Unit,
        onCreate: () -> Unit
    ) {
        while (true) {
            if (list.isEmpty()) {
                println("$title\nСписок пуст")
            } else {
                println(title)
                list.forEachIndexed { index, item ->
                    println("$index. $item")
                }
            }
            println("\n${list.size}. Создать\n${list.size + 1}. Выход\n\nВведите число для выбора пункта меню:")

            when (val input = ConsoleApp().input().toIntOrNull()) {
                in list.indices -> onSelect(list[input!!])
                list.size -> onCreate()
                list.size + 1 -> return
                else -> {
                    println("Пожалуйста, введите число соответствующее пункту меню.")
                    continue
                }
            }
        }
    }
}