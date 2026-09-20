class Solution {

    fun mergeHalves(arr: IntArray, start: Int, middle: Int, end: Int) {
        val temp = IntArray(end - start + 1)
        var i = start
        var j = middle + 1
        var k = 0

        while (i <= middle && j <= end) {
            if (arr[i] <= arr[j]) {
                temp[k] = arr[i]
                i++
            } else {
                temp[k] = arr[j]
                j++
            }
            k++
        }

        while (i <= middle) {
            temp[k] = arr[i]
            i++
            k++
        }

        while (j <= end) {
            temp[k] = arr[j]
            j++
            k++
        }

        for (t in temp.indices) {
            arr[start + t] = temp[t]
        }
    }
    
    fun sort(arr: IntArray, start: Int, end: Int) {
        if (start >= end) return
        val middle = start + (end - start)/2
        sort(arr, start, middle)
        sort(arr, middle + 1, end)
        mergeHalves(arr, start, middle, end)
    }

    fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int) {
        /*
        we could just overwrite the 0s with the nums2 values,
        then implement a merge sort to get O(n*log n) time complexity
        Insertion sort would be O(n^2)
        
        */

        for (i in 0 until n) nums1[m + i] = nums2[i]
        sort(nums1, 0, nums1.size - 1)

    }
}
