class BaseConverter(base: Int, digits: IntArray) {
    val value:Int 
    init {
        if (base < 2) throw IllegalArgumentException("Bases must be at least 2.")
        if (digits.size == 0) throw IllegalArgumentException("You must supply at least one digit.")
        if(digits[0] == 0 && digits.size > 1) throw IllegalArgumentException("Digits may not contain leading zeros.")
        value = digits.filter(){ o -> when {
            (o < 0) -> throw IllegalArgumentException("Digits may not be negative.")
            (o < base) -> true
            else -> throw IllegalArgumentException("All digits must be strictly less than the base.") 
        }}.foldRightIndexed(0) { index, element, o ->  
            o + Math.pow(base.toDouble(), ( digits.size - index - 1).toDouble()).toInt() * element 
        }
    }
    fun convertToBase(newBase: Int, tempNewValue:Int = -999): IntArray {
        if (newBase < 2) throw IllegalArgumentException("Bases must be at least 2.")
        val newValue = when (tempNewValue) {
            -999 -> value
            else -> tempNewValue
        }
        if(value == 0) return intArrayOf(0)
        if (newValue == 0) return intArrayOf()
        val digit = newValue % newBase
        return convertToBase(newBase, newValue / newBase) + intArrayOf(digit)
    }
}