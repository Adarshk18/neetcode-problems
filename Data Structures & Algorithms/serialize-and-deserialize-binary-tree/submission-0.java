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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        dfsSerial(root,sb);
        return sb.toString();
    }

    private void dfsSerial(TreeNode root, StringBuilder sb){
        if(root==null){
            sb.append("N,");
            return;
        }

        sb.append(root.val).append(",");
        dfsSerial(root.left,sb);
        dfsSerial(root.right,sb);
    }

    int indx;
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] vals = data.split(",");
        int indx = 0;
        return dfsDeserial(vals);
    }

    private TreeNode dfsDeserial(String[] vals){
        if(vals[indx].equals("N")){
            indx++;
            return null;
        }

        TreeNode node = new TreeNode(Integer.parseInt(vals[indx]));
        indx++;
        node.left = dfsDeserial(vals);
        node.right = dfsDeserial(vals);

        return node;
    }
}
