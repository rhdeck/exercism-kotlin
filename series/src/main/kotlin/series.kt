package Series
fun slices(length: Int, source: String): List<List<Int>> {
    val numberList = source
        .toCharArray()
        .filter() { it in ('0'..'9')}
        .map(){ (it - '0').toInt() }
    return numberList
        .foldIndexed(emptyList<List<Int>>()) { index, o, _ -> 
            when {
                index > numberList.size - length -> o
                else -> o.plusElement(numberList.slice((index..(index + length - 1))))
            }       
        }
} 