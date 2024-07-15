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
    int max=0;
    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null){
            return 0;
        }
        int c=hauteur(root.right)+hauteur(root.left)+2;
        return Math.max(c,Math.max(diameterOfBinaryTree(root.left),diameterOfBinaryTree(root.right)));

    }
    public int hauteur(TreeNode arb){
        if (arb==null){
            return -1;
        }
        return 1+Math.max(hauteur(arb.left),hauteur(arb.right));
    }
    
}