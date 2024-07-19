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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return backtraking(root,targetSum,0);
    }

    public boolean backtraking(TreeNode root,int tagetSum,int accum){
        if(root==null){
            return false;
        }
        accum=accum+root.val;
        if(accum==tagetSum && root.left==null && root.right==null){
            return true;
        }
        if(backtraking(root.left,tagetSum,accum)){
            return true;
        }
        if(backtraking(root.right,tagetSum,accum)){
            return true;
        }
        accum=accum-root.val;
        return false;
    }
}