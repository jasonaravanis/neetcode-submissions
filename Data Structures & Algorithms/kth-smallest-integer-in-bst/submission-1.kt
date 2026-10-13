/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {

    // time: O(n)
    // space: O(log(n)) assuming balanced tree, otherwise O(n) if unbalanced

    var nodeCount = 0
    var answer = -1

    fun kthSmallest(root: TreeNode?, k: Int): Int {
        /*
        traverse the BST using DFS with inorder traversal

        keep a counter for each node we visit

        when counter is equal to k, return the node value
        */

        nodeCount = k
        dfs(root)

        return answer
    }

    private fun dfs(node: TreeNode?) {
        if (node == null) {
            return
        }

        dfs(node.left)
        if (nodeCount == 0) return

        nodeCount--
        if (nodeCount == 0) {
            answer = node.`val`
            return
        }

        dfs(node.right)
    }
}
