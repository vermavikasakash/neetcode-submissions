class Solution {
    int k;
    Integer ans = null;

    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        traverse(root);
        return ans;
    }

    void traverse(TreeNode curr) {
        if (curr == null || ans != null)  return;

        traverse(curr.left);
        k--;
        if (k == 0) {
            ans = curr.val;
            return;
        }
        traverse(curr.right);
    }
}