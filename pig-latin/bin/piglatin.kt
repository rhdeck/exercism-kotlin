package PigLatin
fun translate(source: String): String = source.split(" ").map() {word -> 
    when (word.toLowerCase().substring(0,2)) {
        "xr", "yt" -> word + "ay" //Special case
        else -> {
            when (word.toLowerCase().get(0)) {
                'a','e','i','o','u' -> word + "ay"
                else -> {
                    val vowelIndex = word.indexOfAny("aeiouy".toCharArray(),1)
                    val vowel = word.get(vowelIndex)
                    val lcase = when (vowel) {
                        'u' -> {
                            when (word.get(vowelIndex -1)) {
                                'q' ->  word.toLowerCase().substring(vowelIndex + 1) + word.toLowerCase().substring(0, vowelIndex + 1) + "ay"
                                else -> word.toLowerCase().substring(vowelIndex) + word.toLowerCase().substring(0, vowelIndex) + "ay"
                            }                   
                        else -> word.toLowerCase().substring(vowelIndex) + word.toLowerCase().substring(0, vowelIndex) + "ay"
                    }
                    when (word.get(0) in ('A'..'Z')) {
                        true -> lcase.substring(0,1).toUpperCase() + lcase.substring(1)
                        false -> lcase
                    }
                }
            }
        }
    }
}.joinToString(" ")