data class RotationalCipher(val offset: Int) {
    fun encode(clearText: String): String = clearText.toCharArray().map() { when (it) {
        in ('A'..'Z') -> 'A' + ((it - 'A' + offset) % 26) 
        in('a'..'z') -> 'a' + ((it - 'a' + offset) % 26)
        else -> it
    }}.joinToString("")
    fun decode(encodedText: String): String = RotationalCipher(-1 * offset).encode(encodedText)
}