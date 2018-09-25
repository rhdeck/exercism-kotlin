class MinesweeperBoard(val board: List<String>) {
    private val asArray: List<CharArray>
    private val height: Int
    private val width: Int
    init {
        when {
            board.size > 0 -> {
                asArray = board.map() { row -> row.toCharArray() }
                height = board.size
                width = asArray[0].size
            }
            else -> {
                asArray = listOf<CharArray>()
                height = 0
                width = 0
            }
        }
    }
    fun withNumbers(): List<String> = when {
        height == 0 -> listOf<String>()
        else -> asArray.mapIndexed() { rowNumber, rowArray ->
            rowArray.mapIndexed() { columnNumber, cellChar -> 
                when { 
                    cellChar == '*' -> '*'
                    else -> {
                        val i = ((rowNumber -1)..(rowNumber + 1)).fold(0) { o, rowNum -> 
                            o + ((columnNumber - 1)..(columnNumber + 1)).fold(0) { o, thisColumn -> 
                                o + when {
                                    rowNum !in (0..(height -1)) -> 0
                                    thisColumn !in (0..(width -1)) -> 0
                                    else -> when (asArray.elementAt(rowNum)[thisColumn]) {
                                        '*'-> 1 
                                        else -> 0
                                    }
                                }
                            }
                        }
                        when {
                            i == 0 -> ' '
                            else -> '0'.plus(i)
                        }
                    }
                }
            }.joinToString("")
        }
    }
}