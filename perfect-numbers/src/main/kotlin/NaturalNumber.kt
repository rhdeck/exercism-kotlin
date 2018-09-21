
enum class Classification {
    DEFICIENT, PERFECT, ABUNDANT
}

fun classify(naturalNumber: Int): Classification {
    if (naturalNumber < 1) throw RuntimeException("Natural numbers are positive integers") 
    val factors = (1..naturalNumber/2).fold(listOf<Int>()) { factors, factor -> 
        if (naturalNumber.rem(factor) == 0) factors.plusElement(factor) else factors
    }
    val sumOfFactors = factors.fold(0) { factor, total -> total + factor }
    return when {
        (naturalNumber == sumOfFactors) -> Classification.PERFECT
        (naturalNumber < sumOfFactors ) -> Classification.ABUNDANT
        else ->  Classification.DEFICIENT
    }
}