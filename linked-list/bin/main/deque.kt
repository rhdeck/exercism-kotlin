class Deque<T>() {
    val myList = mutableListOf<T>()
    fun push(element: T) { myList.add(element)}
    fun pop(): T {
        val t = myList.elementAt(myList.size - 1)
        myList.removeAt(myList.size - 1)
        return t
    }
    fun shift(): T {
        val t = myList.elementAt(0)
        myList.removeAt(0)
        return t
    }
    fun unshift(element: T) { myList.add(0, element)}
}