package Flattener
fun flatten(list:List<Any?>): List<Int> = list.fold(listOf<Int>()) { a, e -> when (e) {
    is Int -> a.plus(e)
    is List<*> -> a.plus(flatten(e))
    else -> a
}}