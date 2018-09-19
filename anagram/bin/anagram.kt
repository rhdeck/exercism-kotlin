class Anagram(val seed:String) {
    var _anagrams = mutableListOf<String>()
    val anagrams:List<String>
        get() { permutate(seed.toLowerCase(), 0, seed.length - 1);  return _anagrams } 
    fun permutate(str:String, s: Int, e: Int) {
        var st = str
        if(s == e) return 
        for(i in s+1..e) {
            permutate(st, s+1, e)
            st = switch(st, s, i)
            permutate(st, s+1, e)
            _anagrams.add(st)
        }
    }
    fun switch(str:String, a: Int, b: Int) : String {
        var ca = str.toCharArray()
        val t = ca[a]
        ca[a] = ca[b]
        ca[b] = t
        return ca.joinToString("")
    }
    fun match(l:List<String>): Set<String> {
        val il = l.map() { s -> s.toLowerCase() }
        val o = anagrams.intersect(il).map() { s -> l[il.indexOf(s)] }.filter() { s -> s.toLowerCase() != seed.toLowerCase() } 
        return o.toSet()
    }

}