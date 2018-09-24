package Board
import java.math.BigInteger
fun getGrainCountForSquare(squareIndex: Int) : BigInteger = when {
    squareIndex < 1 || squareIndex > 64 -> throw IllegalArgumentException("Only integers between 1 and 64 (inclusive) are allowed")
    squareIndex == 1 -> BigInteger.valueOf(1)
    else -> BigInteger.valueOf(2) * getGrainCountForSquare(squareIndex - 1)
}
fun getTotalGrainCount(): BigInteger = (1..64).fold(BigInteger.valueOf(0)) { o, index -> o + getGrainCountForSquare(index)}