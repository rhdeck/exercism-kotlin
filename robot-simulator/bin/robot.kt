class Robot(var gridPosition: GridPosition = GridPosition(0,0), var orientation: Orientation = Orientation.NORTH) {
    fun turnRight() { orientation = Orientation.values()[(orientation.ordinal + 1) % Orientation.values().size] }
    fun turnLeft() { orientation = Orientation.values()[(orientation.ordinal - 1 + Orientation.values().size)  % Orientation.values().size] }
    // Terse, mathy answer
    fun advance() { gridPosition = GridPosition(
        gridPosition.x + orientation.ordinal % 2 * Math.pow(-1.0, (orientation.ordinal / 2).toDouble()).toInt(), 
        gridPosition.y + (orientation.ordinal % 2 -1) * Math.pow(-1.0, (orientation.ordinal / 2 - 1).toDouble()).toInt()
    )}
    // Old, less-mathy answer
    // when (orientation) {
    //     Orientation.NORTH -> GridPosition(gridPosition.x, gridPosition.y + 1)
    //     Orientation.SOUTH -> GridPosition(gridPosition.x, gridPosition.y - 1)
    //     Orientation.EAST -> GridPosition(gridPosition.x + 1, gridPosition.y)
    //     Orientation.WEST -> GridPosition(gridPosition.x - 1, gridPosition.y)
    // }}
    fun simulate(commandlist: String) { commandlist.toCharArray().forEach() { command -> when (command) {
        'R' -> turnRight()
        'L' -> turnLeft()
        'A' -> advance()
        else -> throw IllegalArgumentException("Only R L and A are valid commands")
    }}}
}