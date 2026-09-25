/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun merge(
        list1: ListNode?,
        list2: ListNode?,
    ): ListNode? {
        val sentinel = ListNode(0)
        var tail = sentinel
        var l1 = list1
        var l2 = list2

        while (l1 != null && l2 != null) {
            var node: ListNode? = null
            if (l1.`val` < l2.`val`) {
                node = l1
                l1 = l1.next
            } else {
                node = l2
                l2 = l2.next
            }
            tail.next = node
            tail = node
        }

        tail.next = l1 ?: l2

        return sentinel.next
    }

    fun mergeKLists(lists: Array<ListNode?>): ListNode? {
        if (lists.isEmpty()) return null
        var store = lists.toMutableList()

        while (store.size > 1) {
            val temp = mutableListOf<ListNode?>()
            for (i in store.indices step 2) {
                val left = store[i]
                val right = store.getOrNull(i + 1)
                val sorted = merge(left, right)
                temp.add(sorted)
            }
            store = temp
        }

        return store.first()
    }
}
