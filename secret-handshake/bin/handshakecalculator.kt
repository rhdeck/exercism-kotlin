package HandshakeCalculator
import Signal 
fun calculateHandshake(source: Int): List<Signal> {
    val out = mutableListOf<Signal>()
    if (source and 1 > 0) out.add(Signal.WINK)
    if (source and 2 > 0) out.add(Signal.DOUBLE_BLINK)
    if (source and 4 > 0) out.add(Signal.CLOSE_YOUR_EYES)
    if (source and 8 > 0) out.add(Signal.JUMP)
    if (source and 16 > 0 ) out.reverse()
    return out
}