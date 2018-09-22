package ScrabbleScore
fun scoreWord(word: String) = word.toUpperCase().toCharArray().fold(0) { s, c -> s + when (c) {
    'A', 'E', 'I', 'O', 'U', 'L', 'N', 'R', 'S', 'T' -> 1
    'D', 'G' -> 2
    'B', 'C', 'M', 'P' -> 3
    'F', 'H', 'V', 'W', 'Y' -> 4
    'K' -> 5
    'J', 'X' -> 8
    'Q', 'Z' -> 10
    else -> throw IllegalArgumentException("words must be made solely of letters")
}}
