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
    int res=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return res;
        
    }

    public int dfs(TreeNode root){
        if(root==null){
            return 0;
        }
        int leftMax=dfs(root.left);
        int rightMax=dfs(root.right);
        leftMax=Math.max(leftMax,0);
        rightMax=Math.max(rightMax,0);

        res=Math.max(res,root.val+leftMax+rightMax);

        return root.val+Math.max(leftMax,rightMax);
    }
}