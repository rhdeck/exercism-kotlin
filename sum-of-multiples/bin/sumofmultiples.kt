package SumOfMultiples
fun sum(factors: Set<Int>, max: Int): Int = factors.flatMap(){ i ->
    if(i < 1 ) throw IllegalArgumentException("Factors must natural numbers (integers greater than zero")
    (1..(max-1)/i).map() { j -> i * j }
}.distinct().fold(0) { o, i -> o + i }
