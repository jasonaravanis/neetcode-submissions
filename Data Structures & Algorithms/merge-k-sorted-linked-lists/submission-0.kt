class Solution {
    fun isListsEmpty(lists: Array<ListNode?>): Boolean {
        for (element in lists) {
            if (element !== null) return false
        }
        return true
    }

    fun mergeKLists(lists: Array<ListNode?>): ListNode? {
        val dummy: ListNode = ListNode(0)
        var tail: ListNode = dummy

        while (!isListsEmpty(lists)) {
            var minIndex: Int = -1
            var minNode: ListNode? = null
            for (i in lists.indices) {
                val current = lists[i] ?: continue
                if (minNode == null || current.`val` < minNode.`val`) {
                    minIndex = i
                    minNode = current
                }
            }
            if (minNode !== null) {
                lists[minIndex] = minNode.next
                tail.next = minNode
                tail = minNode
                tail.next = null    
            }
            
        }

        return dummy.next
    }
}