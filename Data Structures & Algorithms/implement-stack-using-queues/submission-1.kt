class MyStack {
    private val q1 = ArrayDeque<Int>()
    private val q2 = ArrayDeque<Int>()

    fun push(x: Int) {
        q2.addLast(x)
        while (q1.isNotEmpty()) {
            q2.addLast(q1.removeFirst())
        }
        while (q2.isNotEmpty()) {
            q1.addLast(q2.removeFirst())
        }
        q2.clear()
    }

    fun pop(): Int? {
        if (q1.isEmpty()) return null
        return q1.removeFirst()
    }

    fun top(): Int? = q1.firstOrNull()

    fun empty(): Boolean = q1.isEmpty()
}


/**
 * Your MyStack object will be instantiated and called as such:
 * val obj = MyStack()
 * obj.push(x)
 * val param_2 = obj.pop()
 * val param_3 = obj.top()
 * val param_4 = obj.empty()
 */





























