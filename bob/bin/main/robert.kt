package Bob
fun hey(message: String) = when {
    message.trim().length == 0 -> "Fine. Be that way!"
    // This seems like a bug in the test. - "calm down" is in the instructions.
    // (message.trim().last() == '?') && (message.toUpperCase() == message) && (message.toLowerCase() != message) -> "Calm down, I know what I'm doing!"
    (message == message.toUpperCase())  && (message != message.toLowerCase()) -> "Whoa, chill out!"
    message.trim().last() == '?' -> "Sure."
    else -> "Whatever."
}