class Solution {
    fun climbStairs(n: Int): Int {
        if (n <= 2) return n
        val arr = IntArray(2)
        arr[0] = 1
        arr[1] = 2
        
        var stepsRemaining = n - 2
        
        while (stepsRemaining > 0) {
            val temp = arr[0] + arr[1]
            arr[0] = arr[1]
            arr[1] = temp
            stepsRemaining--
        }
        return arr[1]
    }
}
