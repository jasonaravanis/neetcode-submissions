/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {

    fun getMinNode(root: TreeNode): TreeNode {
        var current = root
        var next = current.left
        while (next != null) {
            current = next
            next = current.left
        }
        return current
    }

    fun deleteNode(
        root: TreeNode?,
        key: Int,
    ): TreeNode? {
       if (root == null) return null

       when {
            key < root.`val` -> root.left = deleteNode(root.left, key)
            key > root.`val` -> root.right = deleteNode(root.right, key)
            else -> {
                val left = root.left
                val right = root.right

                when {
                    left == null -> return root.right
                    right == null -> return root.left
                    else -> {
                        val minNode = getMinNode(right)
                        root.`val` = minNode.`val`
                        root.right = deleteNode(root.right, minNode.`val`)
                    }
                }
            }
       }
        return root
    }
}
