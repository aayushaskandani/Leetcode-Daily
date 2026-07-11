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

    // Serialize
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        preorder(root, sb);
        return sb.toString();
    }

    private void preorder(TreeNode root, StringBuilder sb) {

        if (root == null) {
            sb.append("N,");
            return;
        }

        sb.append(root.val).append(",");

        preorder(root.left, sb);
        preorder(root.right, sb);
    }

    int index = 0;

    // Deserialize
    public TreeNode deserialize(String data) {

        String[] nodes = data.split(",");

        index = 0;

        return buildTree(nodes);
    }

    private TreeNode buildTree(String[] nodes) {

        if (nodes[index].equals("N")) {
            index++;
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(nodes[index++]));

        root.left = buildTree(nodes);
        root.right = buildTree(nodes);

        return root;
    }
}