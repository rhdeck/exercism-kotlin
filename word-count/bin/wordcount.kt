package WordCount
fun phrase(source: String): Map<String, Int> = source
    .toLowerCase()
    .split(Regex("[^a-z0-9'\"]"))
    .filter(){w -> w.length > 0 }
    .map() { w  -> w.trim('"').trim('\'')}
    .fold(mapOf<String, Int>()) { o,  word ->
        o + when (o.get(word)) {
            null ->  word.to(1)
            else -> word.to(o.get(word) as Int + 1)
        }
    }