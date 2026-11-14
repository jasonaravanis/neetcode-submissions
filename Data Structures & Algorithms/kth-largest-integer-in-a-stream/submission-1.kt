
import java.util.PriorityQueue

class KthLargest(
    private val k: Int,
    nums: IntArray,
) {
    private val heap = PriorityQueue<Int>()

    init {
        val sortedNums = nums.sortedArrayDescending().take(k)
        heap.addAll(sortedNums)
    }

    fun add(`val`: Int): Int {
        heap.add(`val`)
        if (heap.size > k) heap.poll()
        return heap.peek()
    }
}
