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
    public int max;
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
         this.max = 0;
        solve(root,1);

        return max;
    }
    void solve(TreeNode root, int depth){
         if(root == null) return;
         max = Math.max(max,depth);
         
         solve(root.left, depth +1);
         solve(root.right, depth +1);
    }
}
