package CollatzCalculator
fun computeStepCount(source: Int):Int = when {
    source < 1 -> throw IllegalArgumentException("Only natural numbers are allowed")
    source == 1 -> 0
    else -> when (source % 2) {
        1 -> 1 + computeStepCount(source * 3 + 1)
        0 -> 1 + computeStepCount(source / 2)
        else -> throw RuntimeException("Math is wrong")
    }
}