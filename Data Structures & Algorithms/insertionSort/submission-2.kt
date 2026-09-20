// Definition for a pair
// class Pair(var key: Int, var value: String)

class Solution {
    fun insertionSort(pairs: MutableList<Pair>): List<List<Pair>> {

        val mutableList = mutableListOf<List<Pair>>()

        if (pairs.isEmpty()) return mutableList

        mutableList.add(pairs.toList())
        for (i in 1 until pairs.size) {
            var j = i - 1
            while (j >= 0 && pairs[j].key > pairs[j + 1].key) {
                var temp = pairs[j]
                pairs[j] = pairs[j + 1]
                pairs[j + 1] = temp
                j -= 1
            }
            mutableList.add(pairs.toList())
        }

        return mutableList.toList()
    }
}
