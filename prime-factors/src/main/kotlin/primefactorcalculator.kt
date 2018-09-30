//ISSUE: I do not understand how to make this work with both longs and ints at the same time.
package PrimeFactorCalculator 
fun primeFactors(source: Int, start: Int = 2): List<Int> = when (source % start) {
    0 -> listOf<Int>(start) + primeFactors(source / start, start)
    else -> when {
        start < source  -> primeFactors(source, start + 1)
        else -> listOf<Int>()
    }
}
