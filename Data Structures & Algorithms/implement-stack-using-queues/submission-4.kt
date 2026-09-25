class MyStack {
    val store = ArrayDeque<Int>()
    val temp = ArrayDeque<Int>()

    fun push(x: Int) {
        store.addLast(x)
        
        for (i in 0 until store.size - 1) {
            store.addLast(store.removeFirst())
        }
    }

    fun pop(): Int = store.removeFirst()

    fun top(): Int = store.first()

    fun empty(): Boolean = store.isEmpty()
}


/**
 * Your MyStack object will be instantiated and called as such:
 * val obj = MyStack()
 * obj.push(x)
 * val param_2 = obj.pop()
 * val param_3 = obj.top()
 * val param_4 = obj.empty()
 */





























