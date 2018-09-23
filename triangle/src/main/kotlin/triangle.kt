data class Triangle(val rawa: Number, val rawb: Number, val rawc: Number) {
    val a = rawa.toDouble()
    val b = rawb.toDouble()
    val c = rawc.toDouble()
    val isEquilateral: Boolean 
    val isIsosceles: Boolean
    val isDegenerate: Boolean
    val isScalene: Boolean 
    init {
        when {
            (a + b + c) == 0.0  || a + b < c || a + c < b || b + c < a -> throw IllegalArgumentException("Not a legal triangle")
            a == b && b == c -> {
                isEquilateral = true
                isIsosceles = true
                isScalene = false
            }
            a == b || a==c || b==c -> {
                isEquilateral = false
                isIsosceles = true
                isScalene = false
            }
            else -> {
                isEquilateral = false
                isIsosceles = false
                isScalene = true
            }
        }
        isDegenerate = when {
            a + b == c || a + c == b || b + c == a -> true
            else -> false
        } 
    }
}