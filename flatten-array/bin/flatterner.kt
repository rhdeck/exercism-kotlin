package Flattener
fun flatten(list:List<Any?>): List<Int> = list.fold(listOf<Int>()) { a, e -> when (e) {
    is Int -> a.plus(e)
    is List<*> -> {
        val t = e as? List<Any>
        when { 
           t == null -> a
           else -> a.plus(flatten(e)) 
        }
    }
    else -> a
}}