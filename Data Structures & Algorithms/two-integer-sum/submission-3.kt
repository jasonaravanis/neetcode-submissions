class Solution {
    fun twoSum(
        nums: IntArray,
        target: Int,
    ): IntArray {
        val knownNums = mutableMapOf<Int, Int>()
        nums.forEachIndexed { i, v ->
            val complement = target - v
            val j = knownNums[complement]
            if (j != null) {
                return intArrayOf(j, i)
            } else {
                knownNums[v] = i
            }
        }
        throw Exception("Something went wrong")
    }
}