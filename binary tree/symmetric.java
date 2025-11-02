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

    List<Integer> left = new ArrayList<>();
    List<Integer> right = new ArrayList<>();

    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        pre(root.left);
        in(root.right);
        System.out.println(left);
        System.out.println(right);

        if (left.size() != right.size()) return false;
        for (int i = 0; i < left.size(); i++) {
            if (left.get(i) != right.get(i)) {
                return false;
            }
        }
        return true;
    }

    public void pre(TreeNode root) {
        if (root == null) {
            left.add(-1);
            return;
        }
        left.add(root.val);
        pre(root.left);
        pre(root.right);
    }

    public void in(TreeNode root) {
        if (root == null) {
            right.add(-1);
            return;
        }
        right.add(root.val);
        in(root.right);
        in(root.left);
    }
}
