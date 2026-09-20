class Solution {
    fun removeElement(nums: IntArray, `val`: Int): Int {
        val target = `val`
        var newNumsIndex = 0
        val newNums = IntArray(nums.size)
        for (num in nums) {
            if (num != target) {
                newNums[newNumsIndex] = num
                newNumsIndex++
            }
        }
        for (i in 0 until newNumsIndex) {
            nums[i] = newNums[i]
        }
        return newNumsIndex
    }
}
