
class Solution {
    
   public List<Integer> rightSideView(TreeNode root) {
    List<Integer> ans = new ArrayList<>();
    if (root == null) return ans; 

    Queue<List<TreeNode>> queue = new LinkedList<>();
    queue.offer(new ArrayList<>(Arrays.asList(root)));

    while (!queue.isEmpty()) {
        List<TreeNode> curr = queue.poll();
        boolean flag = false;
        List<TreeNode> levelArr = new LinkedList<>();

        for (TreeNode node : curr) {
            if (!flag) {
                ans.add(node.val);
                flag = true;
            }
            if (node.right != null) levelArr.add(node.right);
            if (node.left != null) levelArr.add(node.left);
        }
        
        if (levelArr.size() > 0) queue.offer(levelArr);
    }
    return ans;
}
}
