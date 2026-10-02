/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {

      fun insertIntoBST(
        root: TreeNode?,
        `val`: Int,
    ): TreeNode {
    val node = TreeNode(`val`)
    if (root == null) return node
    
    var current: TreeNode = root
    
    while (true) {
        if (node.`val` < current.`val`) {
            val left = current.left
            if (left == null) {
                current.left = node
                return root
            } else {
                current = left
            }
        } else {
            val right = current.right
            if (right == null) {
                current.right = node
                return root
            } else {
                current = right
            }
        }
    }
}
}
    

