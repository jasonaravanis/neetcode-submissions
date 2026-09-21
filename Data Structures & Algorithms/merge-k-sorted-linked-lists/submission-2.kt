class Solution {
       fun mergeTwoLists(
        list1: ListNode?,
        list2: ListNode?,
    ): ListNode? {
        val sentinel = ListNode(0)
        var tail = sentinel
        var i1 = list1
        var i2 = list2

        while (i1 != null && i2 != null) {
            var node: ListNode?
            if (i1.`val` <= i2.`val`) {
                node = i1
                i1 = i1.next
            } else {
                node = i2
                i2 = i2.next
            }
            tail.next = node
            tail = node
        }

        tail.next = i1 ?: i2

        return sentinel.next
    }

    fun mergeKLists(lists: Array<ListNode?>): ListNode? {
        if (lists.isEmpty()) return null

        var store = lists.clone().toMutableList()

        while (store.size > 1) {
            val temp = mutableListOf<ListNode?>()
            for (i in store.indices step 2) {
                val list1 = store[i]
                val list2 = store.getOrNull(i + 1)
                val merged = mergeTwoLists(list1, list2)
                temp.add(merged)
            }
            store = temp
        }

        return store[0]
    }
}