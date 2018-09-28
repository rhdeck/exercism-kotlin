class DiamondPrinter {
    fun printToList(startChar: Char): List<String> = when (startChar) {
        'A' -> listOf("A")
        else -> {
            val distance = startChar - 'A'
            listOf(
                " ".repeat(distance) + 
                "A" + 
                " ".repeat(distance)
            ) +
            ('B'..startChar).mapIndexed() { index, char -> 
                " ".repeat(distance - index - 1) +
                char +
                " ".repeat(index * 2 + 1) +
                char +
                " ".repeat(distance - index - 1)
            } +
            ('B'..startChar -1).reversed().mapIndexed() { index, char -> 
                " ".repeat(index + 1) +
                char +
                " ".repeat((char - 'A') * 2 - 1) +
                char +
                " ".repeat(index + 1)
            } + (                 
                " ".repeat(distance) +
                "A" +
                " ".repeat(distance)
            )
        }
    }
}