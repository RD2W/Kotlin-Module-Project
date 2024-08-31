data class Archive(val header: String, val notes: MutableList<Note>) {
    override fun toString(): String {
        return "Архив \"$header\""
    }
}