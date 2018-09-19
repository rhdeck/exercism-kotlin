class ForthEvaluator( ) {
    fun evaluateProgram(lines: List<String>) : List<Int> {
        val k = hashMapOf<String,List<String>>()
        return lines.fold(mutableListOf<Int>()) { l, line -> 
            if (line.startsWith(":")) {
                //We are defining a word
                val ws = line.split(' ')
                val op = ws.elementAt(1)
                if(op.toIntOrNull() != null) throw IllegalArgumentException("Cannot redefine numbers")
                val sequence = ws.subList(2, ws.lastIndex)
                k.put(op.toUpperCase(), sequence)
            } else {
                return line.split(' ').fold(mutableListOf<String>()) {l, w ->
                    when(w.toUpperCase()) {
                        in k.keys -> l.addAll(k.get(w.toUpperCase()) ?: listOf<String>())
                        else -> {
                            l.add(w)
                        }
                    }
                    l
                }.fold(l) { l, w -> 
                    when(w.toUpperCase()) {
                        "+" -> {
                            if(l.size < 2) throw IllegalArgumentException("Addition requires that the stack contain at least 2 values")
                            val addend1 = l.last()
                            l.removeAt(l.lastIndex)
                            val addend2 = l.last()
                            l.removeAt(l.lastIndex)
                            l.add(addend1 + addend2) 
                        }
                        "-" -> {
                            if(l.size < 2) throw IllegalArgumentException("Subtraction requires that the stack contain at least 2 values")
                            val subtrahend = l.last()
                            l.removeAt(l.lastIndex)
                            val minuend = l.last()
                            l.removeAt(l.lastIndex)
                            l.add(minuend - subtrahend) 
                        }
                        "/" -> {
                            if(l.size < 2) throw IllegalArgumentException("Division requires that the stack contain at least 2 values")
                            val dividend = l.last()
                            if(dividend == 0) throw IllegalArgumentException("Division by 0 is not allowed")
                            l.removeAt(l.lastIndex)
                            val divisor = l.last()
                            l.removeAt(l.lastIndex)
                            l.add(divisor / dividend)
                        }
                        "*" -> {
                            if(l.size < 2) throw IllegalArgumentException("Multiplication requires that the stack contain at least 2 values")
                            val factor1 = l.last()
                            l.removeAt(l.lastIndex)
                            val factor2 = l.last()
                            l.removeAt(l.lastIndex)
                            l.add(factor1 * factor2)
                        }
                        "DUP" -> {
                            if(l.size < 1) throw IllegalArgumentException("Duplicating requires that the stack contain at least 1 value")
                            l.add(l.last())
                        }
                        "DROP" -> {
                            if(l.size < 1) throw IllegalArgumentException("Dropping requires that the stack contain at least 1 value")
                            l.removeAt(l.lastIndex)
                        }
                        "SWAP" -> {
                            if(l.size < 2) throw IllegalArgumentException("Swapping requires that the stack contain at least 2 values")
                            val oldLast = l.last()
                            l.removeAt(l.lastIndex)
                            val newLast = l.last()
                            l.removeAt(l.lastIndex)
                            l.add(oldLast)
                            l.add(newLast)
                        
                        }
                        "OVER" -> {
                            if(l.size < 2) throw IllegalArgumentException("Overing requires that the stack contain at least 2 values")
                            val i = l.elementAt(l.lastIndex - 1)
                            l.add(i)
                        }
                        else -> {
                            val i = w.toIntOrNull()
                            if(i == null) throw IllegalArgumentException("No definition available for operator \"${w}\"")
                            l.add(i)
                        }
                    }
                    l
                }
            }
            l
        }
    }
}