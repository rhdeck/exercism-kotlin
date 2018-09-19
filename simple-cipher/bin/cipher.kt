import java.util.Random
class Cipher(val _key:String? = null) {
    private val source="abcdefghijklmnopqrstuvwxyz".toCharArray()
    val key:String
    init { 
        if(_key == null) {
            key = Random().ints(100, 0, 26).toArray().map() { i -> source[i] }.joinToString("")
        } else if (_key.length == 0) {
            throw IllegalArgumentException()
        } else if (_key.toCharArray().asList().filter() { i -> source.indexOf(i) == -1 }.size > 0) {
            throw IllegalArgumentException()
        } else {
            key = _key
        }
    }
    fun encode(s:String) : String {
        return s.toCharArray().mapIndexed() { i, c -> source[(source.indexOf(c) + source.indexOf(key.toCharArray()[i]) ) % source.size] }.joinToString("")
    }
    fun decode(s: String) : String {
        return s.toCharArray().mapIndexed() { i, c -> source[(source.indexOf(c) - source.indexOf(key.toCharArray()[i]) + source.size) % source.size]}.joinToString("")
    }
}