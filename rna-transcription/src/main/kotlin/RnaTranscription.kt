fun transcribeToRna(dna: String): String = dna.toCharArray().map(){c-> when (c) {   
    'G'->'C'
    'C'->'G'
    'T'->'A'
    'A'->'U'
    else-> { throw IllegalArgumentException("This is not DNA")}
}}.joinToString("")
