class Solution {

    int[] dcol = { 1, -1, 0, 0 };
    int[] drow = { 0, 0, -1, 1 };

    public int getMaximumGold(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int max = 0;
        int[][] vis = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != 0) {
                    vis[i][j] = 1;
                    max = Math.max(max, maxi(grid, vis, i, j));
                    vis[i][j] = 0;
                }
            }
        }
        return max;
    }

    public int maxi(int[][] grid, int[][] vis, int i, int j) {
        int m = grid.length;
        int n = grid[0].length;
        int max = 0;
        for (int l = 0; l < 4; l++) {
            int nrow = i + drow[l];
            int ncol = j + dcol[l];
            if (
                nrow >= 0 &&
                nrow < m &&
                ncol >= 0 &&
                ncol < n &&
                vis[nrow][ncol] != 1 &&
                grid[nrow][ncol] != 0
            ) {
                vis[nrow][ncol] = 1;
                max = Math.max(max, maxi(grid, vis, nrow, ncol));
                vis[nrow][ncol] = 0;
            }
        }
        // grid[i][j] =0;
        int res = grid[i][j] + max;

        return res;
    }
}
