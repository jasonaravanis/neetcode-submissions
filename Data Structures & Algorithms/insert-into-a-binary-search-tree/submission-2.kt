/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun insertIntoBST(root: TreeNode?, `val`: Int): TreeNode? {
        when {
            root == null -> return TreeNode(`val`)
            `val` < root.`val` -> root.left = insertIntoBST(root.left, `val`)
            `val` > root.`val` -> root.right = insertIntoBST(root.right, `val`)
            else -> return root
        }
        
        return root
    }
}
