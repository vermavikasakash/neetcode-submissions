public class Codec {
    StringBuilder s = new StringBuilder();
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            s.append("null").append('#');
            return "";
        }
        s.append(root.val).append('#');
        serialize(root.left);
        serialize(root.right);

        return s.toString();
    }

    int curIdx = 0;
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.isEmpty()) return null;
        
        curIdx = 0;
        return buildTree(data);
    }

    private TreeNode buildTree(String data) {
        int idxOfHash = data.indexOf('#', curIdx);
        String token = data.substring(curIdx, idxOfHash);
        curIdx = idxOfHash + 1;

        if (token.equals("null")) {
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(token));
        root.left = buildTree(data);
        root.right = buildTree(data);

        return root;
    }
}
