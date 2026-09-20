class Solution {
    fun calPoints(operations: Array<String>): Int {
        val stack = ArrayDeque<Int>()

        fun add(n: Int) {
            stack.addLast(n)
        }

        fun sumTwoPrevious() {
            val last = stack.removeLast()
            val secondLast = stack.last()
            stack.addLast(last)
            stack.addLast(last + secondLast)
        }

        fun addDouble() {
            val newLast = stack.last() * 2
            stack.addLast(newLast)
        }

        fun pop() {
            stack.removeLast()
        }

        for (operation in operations) {
            when {
                operation.toIntOrNull() != null -> add(operation.toInt())
                operation == "+" -> sumTwoPrevious()
                operation == "C" -> pop()
                operation == "D" -> addDouble()
            }
        }

        return stack.sum()
    }
} 
