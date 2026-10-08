class Solution {
    // recursion
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return root;
         solve(root);
        return root;
    }
    void solve(TreeNode curr) {
        TreeNode temp = curr.left;
        curr.left = curr.right;
        curr.right = temp;

        if (curr.left != null)
            solve(curr.left);
        if (curr.right != null)
            solve(curr.right);
    }
}
