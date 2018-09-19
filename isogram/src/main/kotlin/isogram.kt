class Isogram() {
    companion object {
        fun isIsogram(str: String) : Boolean {
            val a = str.toLowerCase().toCharArray().filter() { c -> c >= 'a' && c <= 'z' }
            val s = a.size
            val f = a.distinct().size
            return s == f
        }
    }
}