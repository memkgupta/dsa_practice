class Solution {

    int[][] dp = new int[201][201];

    public int minPathSum(int[][] grid) {
        for (int[] d : dp) Arrays.fill(d, -1);
        return rec(grid, 0, 0);
    }

    public int rec(int[][] grid, int row, int col) {
        int m = grid.length;
        int n = grid[0].length;

        if (row == m - 1 && col == n - 1) {
            return grid[m - 1][n - 1];
        }
        if (dp[row][col] != -1) return dp[row][col];
        int right = Integer.MAX_VALUE;
        int down = Integer.MAX_VALUE;
        if (row + 1 < m) {
            down = rec(grid, row + 1, col);
        }
        if (col + 1 < n) {
            right = rec(grid, row, col + 1);
        }

        return dp[row][col] = grid[row][col] + Math.min(down, right);
    }
}
