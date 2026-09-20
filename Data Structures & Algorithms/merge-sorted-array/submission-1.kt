class Solution {
    fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int) {
        val nums1Values = nums1.take(m).toIntArray()

        var i = 0
        var j = 0
        var k = 0

        while (i < m && j < n) {
            nums1[k++] = if (nums1Values[i] <= nums2[j]) nums1Values[i++] else nums2[j++]
        }

        while (i < m) {
            nums1[k++] = nums1Values[i++]
        }

        while (j < n) {
            nums1[k++] = nums2[j++]
        }

    }
}
