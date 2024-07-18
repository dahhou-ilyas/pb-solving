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

    public int goodNodes(TreeNode root) {
        return goodNodess(root,root.val);
    }
    public int goodNodess(TreeNode root,int maxSofar){
        if(root==null){
            return 0;
        }
        int count =0;
        
        if(root.val>=maxSofar){
            count =1;
            maxSofar=root.val;
        }

        count = count + goodNodess(root.right,maxSofar);
        count = count + goodNodess(root.left,maxSofar);

        return count;
    }

}