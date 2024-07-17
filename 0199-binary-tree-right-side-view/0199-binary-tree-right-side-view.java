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
    
    public List<Integer> rightSideView(TreeNode root) {
        List<List<Integer>> travers=levelOrder(root);
        List<Integer> result=new ArrayList<>();
        for(int i=0;i<travers.size();i++){
            result.add(travers.get(i).get(travers.get(i).size()-1));
        }
        return result;
    }

    // public void travers(TreeNode root,List result){
    //     if(root == null){
    //         return;
    //     }
    //     TreeNode cur=root;
    //     result.add(cur.val);
    //     while(cur!=null){
    //         if(cur.right!=null){
    //             result.add(cur.right.val);
    //         }else{
    //             if(cur.left!=null){
    //                 cur.add(cur.left.val);
    //             }
    //         }
    //     }
    //}


        public List<List<Integer>> levelOrder(TreeNode root) {
        
        List<List<Integer>> result=new ArrayList<>();
        
        if(root==null){
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            int levelSize = queue.size();
            List<Integer> subList = new ArrayList<>();
            for(int i=0;i<levelSize;i++){
                TreeNode curr = queue.poll();
                subList.add(curr.val);
                if (curr.left != null) {
                    queue.add(curr.left);
                }
                if (curr.right != null) {
                    queue.add(curr.right);
                }
            }
            result.add(subList);
        }
        return result;
    }

}