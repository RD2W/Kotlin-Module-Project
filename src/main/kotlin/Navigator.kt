class Navigator {
    companion object {
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

                val input = ConsoleApp().input()
                if (!input.matches(Regex("[0-${list.size + 1}]"))) {
                    println("Пожалуйста, введите число соответствующее пункту меню.")
                    continue
                }

                when (input.toInt()) {
                    in list.indices -> onSelect(list[input.toInt()])
                    list.size -> onCreate()
                    list.size + 1 -> return
                }
            }
        }
    }
}