import java.util.Random
class Cipher(val _key:String? = null) {
    private val source="abcdefghijklmnopqrstuvwxyz".toCharArray()
    val key:String
    get() = keyArray.joinToString("")
    val keyArray:CharArray
    init { 
        keyArray = when {
            _key == null -> Random().ints(100, 0, 26).toArray().map() { i -> source[i] }.joinToString("")
            _key.length == 0 -> throw IllegalArgumentException("Key must have a length greater than 0")
            _key.toCharArray().asList().filter() { i -> source.indexOf(i) == -1 }.size > 0 -> throw IllegalArgumentException("Key must be exclusively lowercase alphabetical characters (a-z)")
            else -> _key
        }.toCharArray()
    }
    fun encode(s:String) = s.toCharArray().mapIndexed() { i, c -> source[(source.indexOf(c) + source.indexOf(keyArray[i]) ) % source.size] }.joinToString("")
    fun decode(s: String) = s.toCharArray().mapIndexed() { i, c -> source[(source.indexOf(c) - source.indexOf(keyArray[i]) + source.size) % source.size]}.joinToString("")
}