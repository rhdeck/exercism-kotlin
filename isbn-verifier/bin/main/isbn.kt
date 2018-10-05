class IsbnVerifier() {
    fun isValid(source:String):Boolean {
        val start = source.toCharArray().filter() { when (it) {
            in ('0'..'9') -> true
            'X' -> true
            else -> false
        }}
        return when {
            start.indexOf('X') in (0..8) -> false
            start.size != 10 -> false
            else -> start.foldIndexed(0) { index, output, c -> output + (10 - index) * when (c) {
                in ('0'..'9') -> (c - '0') 
                'X' -> 10
                else -> throw IllegalArgumentException("This should not be possible")
            }} % 11 == 0
        }
    }
}