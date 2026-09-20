class MyLinkedList {
    private data class Node(
        var next: Node?,
        var previous: Node?,
        var `val`: Int,
    )

    private var head: Node? = null
    private var tail: Node? = null

    private var listLength = 0

    fun get(index: Int): Int {
        if (index < 0 || index >= listLength) {
            return -1
        }

        var i = 0
        var node: Node? = head

        while (node != null && i < index) {
            node = node.next
            i++
        }

        return node?.`val` ?: -1
    }

    fun addAtHead(`val`: Int) {
        val node = Node(next = head, previous = null, `val`)
        if (listLength == 0) {
            head = node
            tail = node
        } else {
            head?.previous = node
            head = head?.previous
        }

        listLength++
    }

    fun addAtTail(`val`: Int) {
        val node = Node(next = null, previous = tail, `val`)
        if (listLength == 0) {
            head = node
            tail = node
        } else {
            tail?.next = node
            tail = tail?.next
        }

        listLength++
    }

    fun addAtIndex(
        index: Int,
        `val`: Int,
    ) {
        if (index < 0 || index > listLength) return

        if (index == 0) {
            addAtHead(`val`)
            return
        }

        if (index == listLength) {
            addAtTail(`val`)
            return
        }

        val newNode = Node(next = null, previous = null, `val`)

        var nodeBefore: Node? = head
        var i = 0

        while (i < index - 1 && nodeBefore !== null) {
            nodeBefore = nodeBefore.next
            i++
        }

        val nodeAfter = nodeBefore?.next

        nodeBefore?.next = newNode
        newNode.previous = nodeBefore
        nodeAfter?.previous = newNode
        newNode.next = nodeAfter

        listLength++
    }

    fun deleteAtIndex(index: Int) {
        if (index < 0 || index >= listLength) return

        var node: Node? = head
        var i = 0

        while (i < index && node !== null) {
            node = node.next
            i++
        }

        val nodeBefore = node?.previous
        val nodeAfter = node?.next

        node?.previous?.next = node?.next
        node?.next?.previous = node?.previous
        
        if (index == 0) {
            head = head?.next
        }
        
        if (index == listLength - 1) {
            tail = tail?.previous
        }

        listLength--
    }
}
