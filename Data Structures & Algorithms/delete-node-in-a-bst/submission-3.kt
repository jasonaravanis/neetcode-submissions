/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {



    fun deleteNode(
        root: TreeNode?,
        key: Int,
    ): TreeNode? {
       // 1. Find the target node to be deleted and its parent
    var parent: TreeNode? = null
    var target = root
    while (target != null && target.`val` != key) {
        parent = target
        target = if (key < target.`val`) target.left else target.right
    }
    if (target == null) return root // key not present

    val left = target.left
    val right = target.right

    // 2. At most one child of target
    if (left == null || right == null) {
        val child = left ?: right
        when {
            parent == null -> return child

            // deleting the root
            parent.left === target -> parent.left = child

            else -> parent.right = child
        }
        return root
    }

    // 3. Two children: find in-order successor (leftmost of right subtree)
    var successorParent: TreeNode = target
    var successor: TreeNode = right

    while (true) {
        val next = successor.left ?: break
        successorParent = successor
        successor = next
    }
    
    target.`val` = successor.`val`
    if (successorParent.left === successor) {
        successorParent.left = successor.right
    } else {
        successorParent.right = successor.right
    }
    return root
    }
}
