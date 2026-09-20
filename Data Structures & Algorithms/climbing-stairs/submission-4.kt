class Solution {
    val climbStairsMap = mutableMapOf<Int, Int>()

    fun climbStairs(n: Int): Int {
       // ways(k) = ways(k - 1) + ways(k - 2)
       // ways(0) = 1 (do nothing)
       // ways(1) = 1

       var a = 1
       var b = 1

       for(i in 0..n-2) {
        var temp = a
        a += b
        b = temp
       }

       return a
       
    }
}
