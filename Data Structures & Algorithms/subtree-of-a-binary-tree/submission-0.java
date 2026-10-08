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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        
        StringBuilder str1 = new StringBuilder();
        StringBuilder str2 = new StringBuilder();

        serialize(root, str1);
        serialize(subRoot, str2);

        return str1.toString().contains(str2.toString());
    }

    void serialize(TreeNode curr, StringBuilder s) {
        if (curr == null) {
            s.append("#");
            return;
        }

        s.append(curr.val).append("$");

        serialize(curr.left, s);
        serialize(curr.right, s);
    }
}
