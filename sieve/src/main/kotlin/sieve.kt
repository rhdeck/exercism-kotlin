package Sieve
fun primesUpTo(max: Int): List<Int> {
    val source = IntArray(max - 1).mapIndexed(){ v, i -> v + 2}.toMutableList()
    var k:Int = 2 
    do {
        if (source.contains(k)) (2..(max / k)).forEach() { factor ->
            source.remove(factor * k)
        }
        k = k + 1
    } while(k < max)
    return source
}