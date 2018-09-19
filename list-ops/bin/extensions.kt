fun <T> List<T>.customAppend(l:List<T>) : List<T> {
    var m:MutableList<T> = this.toMutableList()
    l.forEach() { i -> m.add(i)}
    return m
}
fun <T> List<List<T>>.customConcat() : List<T> {
    var m:MutableList<T> = mutableListOf()
    this.forEach() { i -> m.addAll(i) }
    return m
}
fun <T> List<T>.customFilter(f:(T) -> Boolean) : List<T> {
    var o:MutableList<T> = mutableListOf()
    this.forEach() { i -> if (f(i)) { o.add(i) } } 
    return o
}
val <T> List<T>.customSize : Int 
get() {
    return this.fold(0) { o, _ -> o + 1}
}
fun <T> List<T>.customMap(f:(T) -> T) : List<T> {
    var o:MutableList<T> = mutableListOf()
    this.forEach() { i -> o.add(f(i)) } 
    return o
}
fun <T> List<T>.customFoldLeft(s:T, f:(T, T) -> T) : T {
    var o:T = s
    this.forEach() { i -> o = f(o, i)}
    return o
}
fun <T> List<T>.customFoldRight(s:T, f:(T, T) -> T) : T {
    var o:T = s
    this.customReverse().forEach() { i -> o = f(i, o)}
    return o
}

fun <T> List<T>.customReverse() : List<T> {
    var m:MutableList<T> = mutableListOf()
    this.forEach() { i -> m.add(0, i)}
    return m
}

