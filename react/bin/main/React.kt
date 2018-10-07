class Reactor<T>() {
    // Your compute cell's addCallback method must return an object
    // that implements the Subscription interface.
    var inputCells = mutableListOf<InputCell>()
    var computeCells = mutableListOf<ComputeCell>()
    interface Subscription {
        fun cancel()
    }
    inner class InputCell(var value: T) {
        init {
            inputCells.add(this)
        }
    }
    inner class ComputeCell (vararg params: T, val func: (T)->T) {
        val args = params
        inner class ComputeCellSubscription(val callback: (T)->Unit): Subscription{
            init {
                callbacks.add(this)
            }
            override fun cancel() { callbacks.remove(this) }
        }
        fun test():T = func(args)
        var oldValue:T
        init {
            oldValue = test()
        }
        var callbacks = mutableListOf<ComputeCellSubscription>()
        fun addCallback(callback: (T)->Unit): ComputeCellSubscription = ComputeCellSubscription(callback)
        fun isChanged():Boolean {
            val newValue = test()
            if (newValue != oldValue) {
                oldValue = newValue
                callbacks.forEach(){it.callback(newValue)}
                return true
            }
            return false
        }
    }


}
