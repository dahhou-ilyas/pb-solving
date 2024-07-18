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
    int verificatuer=Integer.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null,null);
    }
    
    private boolean isValidBST(TreeNode node, Integer lower, Integer upper) {

        if (node == null) {
            return true;
        }

        int val = node.val;

        if (lower != null && val <= lower) {
            return false;
        }
        if (upper != null && val >= upper) {
            return false;
        }

        if (!isValidBST(node.right, val, upper)) {
            return false;
        }
        if (!isValidBST(node.left, lower, val)) {
            return false;
        }

        return true;
    }
}