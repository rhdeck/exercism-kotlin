data class Series(val digitStr:String) {
    val digits: List<Int> = digitStr.toCharArray().map { c ->  
        val t = (c - '0').toInt()
        when {
            t < 0 || t > 9 -> throw IllegalArgumentException("all digits must be decimal digits")
            else -> t
        } 
    }
    fun getLargestProduct(length: Int) = when {
        length > digits.size -> throw IllegalArgumentException("Length must be equal to or less than the size of the digits string (presently ${digits.size}")
        else -> (0..(digits.size - length)).fold(0) { r, startIndex -> 
            maxOf(r, digits.subList(startIndex, startIndex + length).fold(1) { r, i -> 
            r * i})
        }
    }
}