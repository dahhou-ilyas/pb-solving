/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isBalanced(TreeNode root) {
       if (root == null) {
        return true;
    }

    // Check the heights of the left and right subtrees
    int leftHeight = maxDepth(root.left);
    int rightHeight = maxDepth(root.right);

    // If the difference in heights is more than 1, the tree is not balanced
    if (Math.abs(leftHeight - rightHeight) > 1) {
        return false;
    }

    // Check if the left subtree is balanced and the right subtree is balanced
    return isBalanced(root.left) && isBalanced(root.right);
         
    }

    private int maxDepth(TreeNode root){
        if(root==null){
            return 0;
        }
        return 1+Math.max(maxDepth(root.right),maxDepth(root.left));
    }
}