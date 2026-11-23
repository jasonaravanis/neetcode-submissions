class Solution {
    fun isAnagram(
        s: String,
        t: String,
    ): Boolean {
        if (s.length != t.length) return false

        val mapS = s.groupingBy { it }.eachCount()
        val mapT = t.groupingBy { it }.eachCount()

        mapS.keys.forEach {
            if (mapT[it] != mapS[it]) return false
        }

        return true
    }
}