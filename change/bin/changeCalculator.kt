// INCOMPLETE - this is only the greedy method ,ao dILA NONCANONICAL TESTS

data class ChangeCalculator(val coins:List<Int>) {
    fun computeMostEfficientChange(value: Int) : List<Int> {
        if(value < 0) throw IllegalArgumentException("Negative totals are not allowed.")
        var newval = value
        val out = coins.sorted().asReversed().fold(mutableListOf<Int>()) { l, c -> 
            val count = newval / c
            print("For ${newval} Adding ${count} couns of value ${c}\n")
            if(count > 0) for (i in 1..count) l.add(c) 
            newval = newval % c
            l
        }.asReversed()
        if(newval > 0) throw IllegalArgumentException("The total ${value} cannot be represented in the given currency.")
        return out
    }
}