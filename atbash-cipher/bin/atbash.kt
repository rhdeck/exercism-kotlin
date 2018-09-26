package Atbash
private val plain = "abcdefghijklmnopqrstuvwxyz".toCharArray()
private val cipher = plain.reversed()
fun encode(plainText: String) = plainText.toLowerCase().toCharArray().filter(){ c -> 
    when (c) {
        in ('0'..'9') -> true
        in ('a'..'z') -> true
        else -> false
    }
}.map(){ c -> 
    val i = plain.indexOf(c)
    when (i) {
        -1 -> c
        else -> cipher[i]
    }
}.joinToString("").chunked(5).joinToString(" ")
fun decode(encodedText: String) = encodedText.toCharArray().filter(){ c-> 
    when (c) {
        in ('0'..'9') -> true
        in ('a'..'z') -> true
        else -> false
    }
}.map(){ c -> 
    val i = cipher.indexOf(c)
    when {
        i == -1 -> c
        else -> plain[i]
    }
}.joinToString("")