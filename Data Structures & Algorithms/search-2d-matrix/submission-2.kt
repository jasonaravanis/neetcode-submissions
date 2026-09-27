/*
matrix = array of rows
m = number of rows, n = number of columns
for row r: r[i] <= r[j] where i < j

r1[n - 1] < r2[0]

time: O(m * n) to make a single ascending row

Binary search on that row is O(log(m * n))

There is a more efficient way, instead of manually making a
single big row, I need to way convert an index in that imaginary row to a [row,column] lookup in the given matrix

assuming m = 3 and n = 4
i = 0 -> [0, 0]
i = 1 -> [0, 1]
i = 2 -> [0, 2]

fun getCoords(i: Int): Pair<Int, Int> {
var a = (i / m)
var b = (i % m) - 1

}

m = 3 and n = 4
*/


class Solution {

    fun getCoords(i: Int, m: Int, n: Int): IntArray {        
        var a = i / n
        var b = i % n

        return intArrayOf(a, b)
    }

    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
        if (matrix.isEmpty() || matrix[0].isEmpty()) return false

        val m = matrix.size
        val n = matrix[0].size
        
        var l = 0
        var r = (m * n) - 1

        while (l <= r) {
            val middleIndex = (l + r)/2
            val mCoords = getCoords(middleIndex, m, n)
            val middleValue = matrix[mCoords[0]][mCoords[1]]

            when {
                middleValue == target -> return true
                middleValue < target -> l = middleIndex + 1
                middleValue > target -> r = middleIndex - 1
            }
        }

        return false

    }
}
