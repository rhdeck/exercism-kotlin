data class Squares(val count: Int = 0) {
    init {
        if(count < 1) throw IllegalArgumentException("Natural Numbers are integers greater than 0")
    }
    fun sumOfSquares() = (1..count).fold(0) {s,i -> s + i * i}
    fun squareOfSum() = Math.pow((1..count).fold(0.0) {s, i -> s + i }, 2.0).toInt()
    fun difference() = squareOfSum() - sumOfSquares()
}