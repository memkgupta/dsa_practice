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

    int sum = 0;

    public int sumOfLeftLeaves(TreeNode root) {
        isLeaf(root);
        return sum;
    }

    boolean isLeaf(TreeNode root) {
        if (root == null) return false;
        if (root.left == null && root.right == null) {
            return true;
        }
        if (root.left != null) {
            boolean left = isLeaf(root.left);
            if (left) {
                sum += root.left.val;
            }
        }
        if (root.right != null) {
            isLeaf(root.right);
        }
        return false;
    }
}
