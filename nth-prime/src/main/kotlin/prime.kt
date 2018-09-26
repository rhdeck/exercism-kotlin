package Prime
val primes = mutableListOf<Int>(2)
fun nth(n: Int):Int = when {
    n == 0 -> throw IllegalArgumentException("There is no zeroth prime.")
    n <= primes.size -> primes[n - 1]
    else -> {
        (1..(n - 1)).forEach() { i -> nth(i)}
        var t = nth(n - 1)
        do {
            t = t + 1
            var isNotPrime = primes.fold(true) { o, p -> o && (t % p != 0) }
        } while (!isNotPrime)
        primes.add(t)
        t
    }
}