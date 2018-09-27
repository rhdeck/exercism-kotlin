class Matrix(val matrix: List<List<Int>>) {
    val saddlePoints: Set<MatrixCoordinate> = matrix.foldIndexed(listOf<MatrixCoordinate>()) {
        rowNumber, o, row -> o.plus(row.foldIndexed(listOf<MatrixCoordinate>()) {
            columnNumber, o, i -> when {
                i == row.max() -> {
                    when (matrix.fold(true) { o, v -> o && v.elementAt(columnNumber) >= i }) {
                        true -> o.plus(MatrixCoordinate(rowNumber, columnNumber))
                        false -> o
                    }
                }
                else -> o
            }
        })
    }.toSet()
}