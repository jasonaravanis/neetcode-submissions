/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
         fun reverseList(head: ListNode? = null): ListNode? {
        if (head?.next == null) return head
        
        val reversedListHead = reverseList(head.next)
        
        head.next?.next = head
        head.next = null
        
        return reversedListHead
    }
}
