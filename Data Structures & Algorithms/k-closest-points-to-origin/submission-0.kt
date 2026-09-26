class Solution {
    private data class PointWithDistance(val x: Int, val y: Int, val di: Double)
    
    private fun sort(arr: Array<PointWithDistance>, start: Int, end: Int) {
        if (start >= end) return
        
        var i = start
        var j = start
        
        while (j < end) {
            if (arr[j].di <= arr[end].di) {
                val temp = arr[j]
                arr[j] = arr[i]
                arr[i] = temp
                i++
            }
            j++
        }
        
        val temp = arr[i]
        arr[i] = arr[end]
        arr[end] = temp
        
        sort(arr, start, i - 1)
        sort(arr, i + 1, end)
        
    }
    
    private fun quickSortPointWithDistance(arr: Array<PointWithDistance>) {
        sort(arr, 0, arr.size - 1)
    }

    fun kClosest(
        points: Array<IntArray>,
        k: Int,
    ): Array<IntArray> {
        val pointsWithDistances: Array<PointWithDistance> = points.map { it ->
            val xSquareDistance = it[0].toDouble().pow(2)
            val ySquareDistance = it[1].toDouble().pow(2)
            val di = sqrt(xSquareDistance + ySquareDistance)
            PointWithDistance(it[0], it[1], di)
        }.toTypedArray()
        
        quickSortPointWithDistance(pointsWithDistances)
        
        return pointsWithDistances.take(k).map { intArrayOf(it.x, it.y) }.toTypedArray()
    }
}
