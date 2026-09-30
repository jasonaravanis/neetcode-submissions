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

        if (root.`val` > node.`val`) {
            root.left = insertIntoBST(root.left, `val`)
        }
        if (root.`val` < node.`val`) {
            root.right = insertIntoBST(root.right, `val`)
        }
        return root
    }


    }
    

