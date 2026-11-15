import java.util.PriorityQueue

class Solution {
    fun findKthLargest(nums: IntArray, k: Int): Int {
        val minHeap = PriorityQueue<Int>()
        
        nums.forEach {
            minHeap.add(it)
            if (minHeap.size > k) minHeap.poll()
        }
        
        return minHeap.peek()
    }
}