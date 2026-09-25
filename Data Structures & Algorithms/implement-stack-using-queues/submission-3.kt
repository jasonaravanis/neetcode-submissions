class MyStack {
    val store = ArrayDeque<Int>()
    val temp = ArrayDeque<Int>()

    fun push(x: Int) {
        while (!store.isEmpty()) {
            temp.addLast(store.removeFirst())
        }
        store.addLast(x)
        while (!temp.isEmpty()) {
            store.addLast(temp.removeFirst())
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





























