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

    List<Integer> list = new ArrayList<>();

    public void rec(int level, TreeNode root) {
        if (root == null) return;
        if (level == list.size()) {
            list.add(root.val);
        }

        rec(level + 1, root.right);
        rec(level + 1, root.left);
    }

    public List<Integer> rightSideView(TreeNode root) {
        rec(0, root);
        return list;
    }
}
