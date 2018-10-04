data class Allergies(val score:Int) {
    fun isAllergicTo(allergen: Allergen): Boolean = (score and allergen.score) == allergen.score
    fun getList(): List<Allergen> = Allergen.values().fold(listOf<Allergen>()) {o, a -> when(isAllergicTo(a)) {
        true -> o + a
        false -> o
    }}
}