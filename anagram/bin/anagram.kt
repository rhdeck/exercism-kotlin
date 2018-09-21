class Anagram(val seed:String) {
    val lcase = seed.toLowerCase()
    val sorted = lcase.toCharArray().sorted()
    fun match(l:List<String>): Set<String> { return l.filter() { s -> when {
        s.toLowerCase() == lcase -> false
        else -> s.toLowerCase().toCharArray().sorted() == sorted 
    }}.toSet() }
}