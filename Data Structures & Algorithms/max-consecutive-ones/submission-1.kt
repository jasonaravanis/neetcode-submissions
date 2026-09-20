class Solution {
    fun findMaxConsecutiveOnes(nums: IntArray): Int {
       var answer = 0
       var count = 0
       for (num in nums) {
        count = if (num == 1 ) count + 1 else 0
        answer = maxOf(count, answer)
       }
       return answer
    }
}
