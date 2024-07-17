/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    List<TreeNode> list1=new ArrayList<>();
    List<TreeNode> list2=new ArrayList<>();
    TreeNode communRoot=null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        parcours(root,p,list1);
        parcours(root,q,list2);
        if(list1.size()>list2.size()){
            for(int i=list2.size()-1;i>=0;i--){
                if(list2.get(i).val==list1.get(i).val){
                    communRoot=list2.get(i);
                    break;
                }
            }
        }else{
            for(int i=list1.size()-1;i>=0;i--){
                if(list2.get(i).val==list1.get(i).val){
                    communRoot=list1.get(i);
                    break;
                }
            }
        }
        return communRoot;
    }
    public void parcours(TreeNode root, TreeNode p,List l){
        if(root==null){
            return;
        }
        if(root.val==p.val){
            l.add(root);
            return;
        }else if(root.val>p.val){
            l.add(root);
            parcours( root.left, p,l);
        }else{
            l.add(root);
            parcours( root.right,  p,l);
        }
    }
}