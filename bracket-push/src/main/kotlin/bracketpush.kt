package BracketPush
val starts = arrayOf('{', '[','(')
val ends = arrayOf('}', ']', ')')
//Trick: initialize with a non-empty list to allow index lookups later without throws
fun isValid(source: String) = (source.toCharArray().fold(listOf('X')){o, c -> 
    when (c) {
        in starts -> o + c
        in ends -> when {
            starts.indexOf(o.last()) == ends.indexOf(c) -> (o.asReversed() - starts[ends.indexOf(c)]).asReversed()
            else -> listOf('X','X') // this just guarantees eventual failure
        }
        else -> o
    }
}.size) == 1