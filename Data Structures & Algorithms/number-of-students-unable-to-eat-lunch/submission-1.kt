class Solution {
  


    fun countStudents(
        students: IntArray,
        sandwiches: IntArray,
    ): Int {
                 var result = students.size

        val count = IntArray(2)
        
        for (student in students) {
            count[student]++
        }
        
        for (s in sandwiches) {
            if (count[s] > 0) {
                count[s]--
                result--
            } else {
                break
            }
        }
        return result
    }
}
