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

    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> l = new ArrayList<>();
        if (root == null) return l;

        q.offer(root);
        while (!q.isEmpty()) {
            List<Integer> sl = new ArrayList<>();
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode e = q.poll();
                if (e.left != null) q.add(e.left);
                if (e.right != null) q.add(e.right);
                sl.add(e.val);
            }
            l.add(sl);
        }
        return l;
    }
}
