/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
  fun buildTree(
        preorder: IntArray,
        inorder: IntArray,
    ): TreeNode? {
        if (preorder.isEmpty() || inorder.isEmpty()) return null

        val root = TreeNode(preorder[0])
        val leftNodeCount = inorder.indexOf(root.`val`)

        val leftInorderArray = inorder.sliceArray(0..leftNodeCount)
        val rightInorderArray = inorder.sliceArray(leftNodeCount + 1 until inorder.size)

        root.left = buildTree(preorder.sliceArray(1..leftNodeCount), leftInorderArray)
        root.right = buildTree(preorder.sliceArray(leftNodeCount + 1 until preorder.size), rightInorderArray)

        return root
    }
}
