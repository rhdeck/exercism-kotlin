class Year(val seedYear: Int) {
    val isLeap: Boolean
    get() = (seedYear % 4 == 0) && ((seedYear % 100 > 0) || (seedYear % 400 == 0))
}