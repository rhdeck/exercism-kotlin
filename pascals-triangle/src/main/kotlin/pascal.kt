// Note the use of plusElement! 
package PascalsTriangle
fun computeTriangle(rows: Int) : List<List<Int>> = when {
    rows < 0 -> throw IllegalArgumentException("Rows can't be negative!")
    rows == 0 -> emptyList<List<Int>>()
    else -> (1..rows).fold(computeTriangle(0)) { o, row -> when (row) {
        1 -> o.plusElement(listOf<Int>(1))
        else -> o.plusElement((0..(row -1)).fold(emptyList<Int>()) { r, index -> when (index) {
            0 -> r + o.last()[0]
            row - 1 -> r + o.last()[index - 1]
            else -> r + (o.last()[index - 1] + o.last()[index])
        }})
    }}
}