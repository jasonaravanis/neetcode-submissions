/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun rightSideView(root: TreeNode?): List<Int> {
        val answer = mutableListOf<Int>()
        
        val queue = ArrayDeque<TreeNode>()
        
        if (root != null) {
            queue.addLast(root) 
        }
        
        while (!queue.isEmpty()) {
            val sublist = mutableListOf<Int>()
            
            for (i in queue.indices) {
                val node = queue.removeFirst()
                sublist.add(node.`val`)
                val left = node.left
                val right = node.right
                
                if (left != null) {
                    queue.addLast(left)
                }
                if (right != null) {
                    queue.addLast(right)
                }
            }
            
            answer.addLast(sublist.removeLast())
        }
        
        return answer
    }
}
