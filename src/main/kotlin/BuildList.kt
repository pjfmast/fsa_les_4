package avans.avd

data class Content(val title: String, val pageNumber: Int)

fun tableOfContents(
    bookTitle: String,
    contents: List<Content>,
    copyRight: String? = null,
): List<String> = buildList{
    add(bookTitle.uppercase())
    add("Table of Contents")
    add("-".repeat(20))
    contents.mapIndexedTo(this) { num, c ->
        "${num +1},${c.title} - (${c.pageNumber})"
    }
    add("-".repeat(20))
    if (copyRight != null) {
        add("")
        add("Copyright $copyRight")
    }
}

fun main() {
    val contents = listOf<Content>(
        Content("Variables, expressions and types", 3),
        Content("Functions", 12),
        Content("Conditionals: when and if", 21),
        Content("Introduction to Classes and Objects", 35),
    )

    val toc = tableOfContents("Kotlin an Illustrated Guide", contents, "2024")

    toc.forEach(::println)
}