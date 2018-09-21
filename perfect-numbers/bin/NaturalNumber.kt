
enum class Classification {
    DEFICIENT, PERFECT, ABUNDANT
}

fun classify(naturalNumber: Int): Classification {
    if (naturalNumber < 1) throw RuntimeException() 
    var factors = (1..naturalNumber/2).fold(mutableListOf<Int>()) { factors, factor -> 
        if (naturalNumber.rem(factor) == 0) factors.add(factor)
        factors
    }
    val sumOfFactors = factors.fold(0) { factor, product -> product + factor }
    return when {
        (naturalNumber == sumOfFactors) -> Classification.PERFECT
        (naturalNumber < sumOfFactors ) -> Classification.ABUNDANT
        else ->  Classification.DEFICIENT
    }
}