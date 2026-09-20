class BrowserHistory(
    homepage: String,
) {
    private data class Node(
        val `val`: String,
        var next: Node? = null,
        var previous: Node? = null,
    )

    private var current: Node = Node(homepage)
    private var head: Node? = current
    private var tail: Node? = current

    fun visit(url: String) {
        val newNode = Node(url)
        current.next = newNode
        newNode.previous = current
        current = newNode
        tail = current
    }

    fun back(steps: Int): String {
        var i = steps

        while (i > 0 && current !== head) {
            current = current.previous!!
            i--
        }
        return current.`val`
    }

    fun forward(steps: Int): String {
        var i = steps

        while (i > 0 && current !== tail) {
            current = current.next!!
            i--
        }

        return current.`val`
    }
}
