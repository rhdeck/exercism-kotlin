class BankAccount() {
    var _notbalance = 0 
    var balance: Int
        get() = when (isOpen) {
            true -> _notbalance
            false -> throw IllegalStateException("Closed accounts have no balance")
        }
        set(value) { 
            when(isOpen) {
            true -> {
                _notbalance = value}
            false -> throw IllegalStateException("Closed accounts cannot be adjusted")
        }}
    var isOpen = true
    fun close() { isOpen = false }
    @Synchronized
    fun adjustBalance(byAmount: Int) { balance = balance + byAmount }
}