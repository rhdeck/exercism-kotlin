class NumberSpeller() {
    fun say(source: Long, skipZero:Boolean = false, prepend:String = ""):String = when {
        source < 0L -> throw IllegalArgumentException("Input must be non-negative")
        source == 0L -> if (skipZero) "" else "zero"
        else -> prepend + when (source) {
            1L ->  "one"
            2L ->  "two"
            3L ->  "three"
            4L ->  "four"
            5L ->  "five"
            6L ->  "six"
            7L ->  "seven"
            8L ->  "eight"
            9L ->  "nine"
            10L -> "ten"
            11L -> "eleven"
            12L -> "twelve"
            13L -> "thirteen"
            14L -> "fourteen"
            15L -> "fifteen"
            16L -> "sixteen"
            17L -> "seventeen"
            18L -> "eighteen"
            19L -> "nineteen"
            in 20..29 -> "twenty" + say(source % 10, true, "-")
            in 30..39 -> "thirty" + say(source % 10, true, "-")
            in 40..49 -> "forty" + say(source % 10, true, "-")
            in 50..59 -> "fifty" + say(source % 10, true, "-")
            in 60..69 -> "sixty" + say(source % 10, true, "-")
            in 70..79 -> "seventy" + say(source % 10, true, "-")
            in 80..89 -> "eighty" + say(source % 10, true, "-")
            in 90..99 -> "ninety" + say(source % 10, true, "-")
            in 100..999 -> say(source / 100, true, prepend) + " hundred " + say(source % 100, true)
            in 1000..999999 -> say(source / 1000, true, "") + " thousand " + say(source % 1000, true)
            in 1000000..999999999 -> say(source / 1000000, true, "") + " million " + say(source % 1000000, true)
            in 1000000000..999999999999 -> say(source / 1000000000, true, "") + " billion " + say(source % 1000000000, true)
            else -> throw IllegalArgumentException("Input must be less than 1000000000000")
       
    }.trim()}
}