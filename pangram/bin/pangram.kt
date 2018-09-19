class Pangram() {
    companion object {
        fun isPangram(s: String) : Boolean {
           return s.toLowerCase().toCharArray().filter() { c -> c >= 'a' && c <= 'z'}.distinct().size == 26
        }
    }
}