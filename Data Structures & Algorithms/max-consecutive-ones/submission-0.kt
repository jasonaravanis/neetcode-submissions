class Solution {
    fun findMaxConsecutiveOnes(nums: IntArray): Int {
        var maxCounter: Int = 0
        var candidateCounter: Int = 0
        for ((i, v) in nums.withIndex()) {
            if (v === 1) {
                candidateCounter++
            } else {
                if (candidateCounter > maxCounter) {
                    maxCounter = candidateCounter
                }
                candidateCounter = 0
            }
            
        }

        if (candidateCounter > maxCounter) {
            maxCounter = candidateCounter
        }
        return maxCounter
    }
}
