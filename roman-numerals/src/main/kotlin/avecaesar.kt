package RomanNumeral
private fun valString(mod: Int, one: Char, five: Char = '?', ten: Char = '?'): String = when (mod) {
    9 -> "" + one + ten
    in (6..8) -> five + (6..mod).map(){one}.joinToString("")
    5 -> "" + five
    4 -> "" + one + five
    in (1..3) -> (1..mod).map(){one}.joinToString("")
    0 -> ""
    else -> throw IllegalStateException("Math is broken ${mod}")
}
fun value(input: Int): String = valString(input / 1000, 'M') + 
    valString((input % 1000) / 100, 'C', 'D', 'M') + 
    valString((input % 100) / 10, 'X', 'L', 'C') + 
    valString(input % 10, 'I', 'V', 'X')