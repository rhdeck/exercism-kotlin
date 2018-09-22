package Luhn
fun isValid(source:String) : Boolean {
    val start = source.toCharArray().filter() { c-> c != ' '}
    val numbers = start.filter() { c -> c >= '0' && c <= '9'}
    return when {
        start.size != numbers.size -> false 
        numbers.size < 2 -> false
        else -> numbers
            .map() { c -> c - '0' }
            .asReversed()
            .mapIndexed() { position, element -> when (position % 2 ) { 
                1 -> when { 
                    element > 4 -> element * 2 - 9
                    else -> element * 2
                }
                else -> element
            }}.fold(0) { sum, element:Int -> sum + element }  % 10 == 0 
}}