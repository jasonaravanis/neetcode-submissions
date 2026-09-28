class Solution {

    fun minEatingSpeed(
        piles: IntArray,
        h: Int,
    ): Int {
      
      var l = 1
      var r = piles.max()
      var response = r

      while (l <= r) {
        val k = l + (r - l) / 2

        val time = piles.sumOf { ceil(it.toDouble() / k).toInt()}

        if (time <= h) {
            response = k
            r = k - 1
        } else {
            l = k + 1
        }
      }

      return response
    }
}
