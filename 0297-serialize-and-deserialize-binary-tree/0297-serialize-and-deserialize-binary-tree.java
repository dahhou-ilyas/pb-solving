/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    public String serialize(TreeNode root) {
        if (root == null) {
            return "#";
        }
        StringBuilder sb = new StringBuilder();
        serializeHelper(root, sb);
        return sb.toString();
    }
    private void serializeHelper(TreeNode node, StringBuilder sb){
        if (node == null) {
            sb.append("#,");
        }else {
            sb.append(node.val).append(",");
            serializeHelper(node.left, sb);
            serializeHelper(node.right, sb);
        }
    }

    public TreeNode deserialize(String data) {
        String[] nodes = data.split(",");
        Queue<String> queue = new LinkedList<>();
        for (String node : nodes) {
            queue.add(node);
        }
        return deserializeHelper(queue);
    }
    private TreeNode deserializeHelper(Queue<String> queue){
        String val = queue.poll();
        if (val.equals("#")) {
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(val));
        node.left = deserializeHelper(queue);
        node.right = deserializeHelper(queue);
        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));