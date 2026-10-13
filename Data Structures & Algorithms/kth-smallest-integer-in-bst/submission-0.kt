/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {

    var nodeCount = 0
    var answer = -1

    fun kthSmallest(root: TreeNode?, k: Int): Int {
        /*
        traverse the BST using DFS with inorder traversal

        keep a counter for each node we visit

        when counter is equal to k, return the node value
        */

        traverse(root, k)

        return answer
    }

    private fun traverse(root: TreeNode?, k: Int) {
        if (root == null) return
        traverse(root?.left, k)
        nodeCount++
        if (nodeCount == k) {
            answer = root.`val`
        }
        traverse(root?.right, k)
    }
}
