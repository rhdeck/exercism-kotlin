package Raindrops
fun convert(source: Int): String { 
    val list = mutableListOf<String>()
    if(source % 3 == 0) list.add("Pling")
    if(source % 5 == 0) list.add("Plang")
    if(source % 7 == 0) list.add("Plong")
    return when {
        list.size > 0 -> list.joinToString("")
        else -> source.toString()
    }
}