package BinarySearch
fun search(list:List<Int>, target: Int, offset: Int = 0, rawLength: Int = -1): Int = when {
    offset >= list.size -> -1
    else -> {
        if (list.size == 0) throw IllegalArgumentException("List cannot be empty")
        val length = when {
            rawLength == -1 -> list.size
            else -> rawLength
        }
        val distance = when {
            length == 1 -> 0
            else -> length / 2 + length % 2
        }
        when {
            offset + distance >= list.size -> -1 
            list[offset + distance] == target -> offset + distance
            distance == 0 -> -1
            list[offset + distance] > target -> search(list, target, offset, distance)
            else -> search(list, target, offset + distance, distance) 
        }
    }
}