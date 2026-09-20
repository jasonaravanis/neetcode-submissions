class MyStack {
    private data class Node(
        var value: Int,
        var next: Node? = null,
        var previous: Node? = null
    )

    private var head: Node? = null
    private var tail: Node? = null
    
    private var size = 0

    fun push(x: Int) {
        val node = Node(value = x, next = null, previous = tail)
        if (head == null) {
            head = node
            tail = node
        } else {
            tail?.next = node
            tail = node
        }
        size++
    }

    fun pop(): Int? {
        if (size == 0) return null
        
        if (size == 1) {
            val node = tail
            tail = null
            head = null
            size = 0
            return node?.value
        } else {
            val node = tail
            tail = tail?.previous
            size--
            return node?.value
        }
        
    }

    fun top(): Int? {
        return tail?.value
    }

    fun empty(): Boolean = size == 0
}


/**
 * Your MyStack object will be instantiated and called as such:
 * val obj = MyStack()
 * obj.push(x)
 * val param_2 = obj.pop()
 * val param_3 = obj.top()
 * val param_4 = obj.empty()
 */





























