class ConsoleApp {
    private val archives = mutableListOf<Archive>()

    internal fun input(): String {
        var userInput: String
        do {
            userInput = readlnOrNull() ?: ""
            val checkInput = userInput.isBlank()
            if (checkInput) println("Ввод не может быть пустым!\nСделайте повторный ввод:")
        } while (checkInput)
        return userInput.trim()
    }

    internal fun launch() {
        Navigator.navigate("\nСписок архивов:", archives, { selectedArchive ->
            Navigator.navigate("\nСписок заметок в архиве \"${selectedArchive.header}\":",
                selectedArchive.notes,
                { selectedNote ->
                    println("\n$selectedNote\nСодержимое:\n[${selectedNote.content}]\n\nНажмите \"Enter\" чтобы вернуться к списку заметок")
                    readlnOrNull()
                },
                {
                    println("\nВведите название заметки:")
                    val header = input()
                    println("\nВведите содержимое заметки:")
                    val content = input()
                    selectedArchive.notes.add(Note(header, content))
                }
            )
        },
            {
                println("\nВведите название архива:")
                val archiveName = input()
                archives.add(Archive(archiveName, mutableListOf()))
            }
        )
    }
}