class Solution {
    val climbStairsMap = mutableMapOf<Int, Int>()

    fun climbStairs(n: Int): Int {
        if (n == 0) return 1
        if (n < 0) return 0

        if (climbStairsMap.containsKey(n)) {
            return climbStairsMap.getValue(n)
        }

        val pathsAfterOneStep = climbStairs(n - 1)
        val pathsAfterTwoStep = climbStairs(n - 2)

        val answer = pathsAfterOneStep + pathsAfterTwoStep

        if (!climbStairsMap.containsKey(n)) {
            climbStairsMap[n] = answer
        }

        return answer
    }
}
