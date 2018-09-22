data class Clock(var hours: Int = 0, var minutes: Int = 0) {
    init {
        reconcile()
    }
    override fun toString(): String = when {
            hours < 10 -> "0" + hours.toString()
            else -> hours.toString()
        } + ":" + when {
            minutes < 10 -> "0" + minutes.toString()
            else ->  minutes.toString()
        }
    
    fun add(minutesToAdd: Int) {
        minutes += minutesToAdd
        reconcile()
    }
    fun reconcile() {
        val hoursToAdd = minutes / 60
        minutes = minutes % 60
        if(minutes < 0) { hours--; minutes += 60 }
        hours = (hours + hoursToAdd) % 24
        if(hours < 0 ) hours += 24
    }
}