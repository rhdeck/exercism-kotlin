class Anagram(val seed:String) {
    val lcase = seed.toLowerCase()
    val sorted = lcase.toCharArray().sorted()
    fun match(l:List<String>): Set<String> = l.filter() { s -> 
        val l = s.toLowerCase()
        when {
            l == lcase -> false
            else -> l.toCharArray().sorted() == sorted 
        }
    }.toSet() 
}