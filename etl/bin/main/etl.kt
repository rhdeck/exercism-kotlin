package ETL
fun transform(source:Map<Int, List<Char>>): Map<Char, Int> = source
    .toList()
    .fold(mapOf<Char, Int>()) { o, pair -> pair.second
        .fold(o) { o, c -> 
            o + Pair(c.toLowerCase(), pair.first)
        }
    }