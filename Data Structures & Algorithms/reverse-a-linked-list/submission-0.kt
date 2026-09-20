/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
      fun reverseList(head: ListNode?): ListNode? {
        var h = head
        var nh: ListNode? = null
        var current = head
        
        while (h != null) {
            current = h
            h = h.next
            current.next = nh
            nh = current
        }
        return nh
    }
}
