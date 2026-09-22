class Solution {
    val stepMap = mutableMapOf<Int, Int>()

    fun climbStairs(n: Int): Int {
        if (n <= 2) return n

        val answer = stepMap[n] ?: (climbStairs(n - 2) + climbStairs(n - 1))
        stepMap[n] = answer
        return answer
    }
}
