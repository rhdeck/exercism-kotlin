package SpiralMatrix
data class position(val x: Int, val y: Int) 

val directions = arrayOf(
    position(1,0),
    position(0,1),
    position(-1,0),
    position(0,-1)
)
fun ofSize(size: Int): Array<IntArray> {
    var out = Array<IntArray>(size) { i -> IntArray(size) { index -> when(i) {
        0 -> index + 1
        else -> 0
    }}}
    var currentPos = position(size - 1,0)
    var lastValue = size
    var direction = directions[1]
    return when (size) {
        0, 1 -> out
        else -> {
            ((size-1) downTo 1 ).forEach() { length -> (0..1).forEach() { 
                (1..length).forEach() {
                    currentPos = position(currentPos.x + direction.x, currentPos.y + direction.y)
                    lastValue  = lastValue + 1
                    out[currentPos.y][currentPos.x] = lastValue
                }
                //Change direction
                direction = directions[(directions.indexOf(direction)+1) % 4]
            }}
            out
        }
    }
}