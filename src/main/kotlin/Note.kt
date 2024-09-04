import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

data class Note(val header: String, val content: String) {
    private val locDataFormatted = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm"))
    override fun toString(): String {
        return "Заметка \"$header\", дата создания: $locDataFormatted"
    }
}