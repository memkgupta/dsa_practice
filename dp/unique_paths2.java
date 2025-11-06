class Solution {

    int[][] dp;

    public int uniquePathsWithObstacles(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        dp = new int[m][n];
        // for(int[] d:dp) Arrays.fill(d,-1);
        if (grid[m - 1][n - 1] == 1 || grid[0][0] == 1) return 0;
        dp[m - 1][n - 1] = 1;
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i == m - 1 && j == n - 1) continue;
                int right = 0;
                int down = 0;
                if (j + 1 < n && grid[i][j + 1] != 1) {
                    right = dp[i][j + 1];
                }
                if (i + 1 < m && grid[i + 1][j] != 1) {
                    down = dp[i + 1][j];
                }
                dp[i][j] = right + down;
            }
        }
        return dp[0][0];
        // return rec(0,0,grid);
    }

    public int rec(int row, int col, int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        if (row == m - 1 && col == n - 1) {
            if (grid[m - 1][n - 1] == 0) return 1;
            else return 0;
        }
        if (dp[row][col] != -1) return dp[row][col];
        int right = 0;
        int down = 0;
        if (col + 1 < n && grid[row][col + 1] != 1) {
            right = rec(row, col + 1, grid);
        }
        if (row + 1 < m && grid[row + 1][col] != 1) {
            down = rec(row + 1, col, grid);
        }
        return dp[row][col] = right + down;
    }
}
