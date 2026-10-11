/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun inorderTraversal(root: TreeNode?): List<Int> {
        val mutableList = mutableListOf<Int>()

        fun recurse(r: TreeNode?) {
            if (r == null) return
            recurse(r.left)
            mutableList.add(r.`val`)
            recurse(r.right)
        }

        recurse(root)

        return mutableList.toList()
    }
}
