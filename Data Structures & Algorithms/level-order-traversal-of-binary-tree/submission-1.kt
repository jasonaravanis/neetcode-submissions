/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
     fun levelOrder(root: TreeNode?): List<List<Int>> {
        val answer = mutableListOf<List<Int>>()
        if (root == null) return answer
        val queue = ArrayDeque<TreeNode>()
        
        queue.add(root)

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
            answer.add(sublist)
        }
        return answer
    }
}
