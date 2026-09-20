class Solution {
    val climbStairsMap = mutableMapOf<Int, Int>()

    fun climbStairs(n: Int): Int {
        var prev = 1
        var last = 0
        for (i in 0 until n) {
            var temp = prev
            prev += last
            last = temp
        }

        return prev
    }
}
