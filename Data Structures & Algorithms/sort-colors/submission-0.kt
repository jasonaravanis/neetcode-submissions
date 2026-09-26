class Solution {
    fun sortColors(nums: IntArray) {
        val countStore = intArrayOf(0, 0, 0)

        for (num in nums) {
            countStore[num] += 1
        }

        var i = 0
        for (j in countStore.indices) {
            repeat(countStore[j]) {
                nums[i++] = j
            }
        }
    }
}