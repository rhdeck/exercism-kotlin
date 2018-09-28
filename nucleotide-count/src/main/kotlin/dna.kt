class Dna(source: String) {
    val nucleotideCounts : Map<Char, Int> = source.fold(mapOf<Char, Int>('G' to 0, 'C' to 0, 'A' to 0, 'T' to 0)) { out, c -> 
        when (c) {
            'G', 'C', 'A', 'T' -> out.plus(Pair(c, out.get(c) as Int + 1))
            else -> throw IllegalArgumentException("nucleotide strings must contain GCAT only")
        }
    }
}