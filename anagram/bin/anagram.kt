class Anagram(val seed:String) {
    fun match(l:List<String>): Set<String> { return l.filter() { s -> match(s) }.toSet() }
    fun match(s: String): Boolean { 
        return when {
            s.toLowerCase() == seed.toLowerCase() -> false
            else -> s.toLowerCase().toCharArray().sorted() == seed.toLowerCase().toCharArray().sorted() 
        }
    }
}