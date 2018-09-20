class Hamming() {
    companion object {
        fun compute(a:String, b:String) : Int {
            if(a.length != b.length) throw IllegalArgumentException("left and right strands must be of equal length.")
            val ba = b.toCharArray()
            return a.toCharArray().foldIndexed(0) { index, result, element -> if (element != ba[index]) result + 1 else result}
        }
    }
}