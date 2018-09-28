class PhoneNumber(text: String) {
    val number:String? = {
        val digits = text.filter() { c -> c in ('0'..'9')}
        when (digits.length) {
            10 -> when {
                digits.get(0) in arrayOf('0', '1') -> null //Demo inline collection
                digits.get(3) in ('0'..'1') -> null //Demo range
                else -> digits
            }
            11 -> when (digits.get(0)) {
                '1' -> PhoneNumber(digits.substring(1,11)).number
                else -> null
            }
            else -> null
        }
    }()
}