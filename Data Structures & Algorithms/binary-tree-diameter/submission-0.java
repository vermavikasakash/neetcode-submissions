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
    int max;
    public int diameterOfBinaryTree(TreeNode root) {
        solve(root);

        return max;
    }
    int solve(TreeNode root) {
        if (root == null) return 0;
        int leftDia = solve(root.left);
        int rightDia = solve(root.right);
        int dia = leftDia + rightDia;
        max = Math.max(dia, max);

        return 1 + Math.max(leftDia,rightDia);
    }
}
