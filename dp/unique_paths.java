class Solution {

    public int uniquePaths(int m, int n) {
        int[][] pre = new int[m][n];
        return helper(pre, 0, 0, m, n);
    }

    int helper(int[][] pre, int i, int j, int m, int n) {
        if (i < 0 || i >= m || j < 0 || j >= n) {
            return 0;
        }
        if (i == m - 1 && j == n - 1) {
            return 1;
        }
        if (pre[i][j] != 0) return pre[i][j];
        int right = helper(pre, i, j + 1, m, n);
        int left = helper(pre, i + 1, j, m, n);
        pre[i][j] = left + right;
        return left + right;
    }
}
