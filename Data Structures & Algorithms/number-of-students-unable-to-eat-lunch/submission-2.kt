class Solution {
  


    fun countStudents(
        students: IntArray,
        sandwiches: IntArray,
    ): Int {
        var students0 = students.count { it == 0 }
        var students1 = students.count { it == 1 }

        for (sandwich in sandwiches) {
            if (sandwich == 0) {
                if (students0 > 0) students0-- else break
            } else {
                if (students1 > 0) students1-- else break
            }
        }
        
        return students0 + students1
    }
}
