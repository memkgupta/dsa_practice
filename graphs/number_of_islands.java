class Solution {

    // Directions — these two arrays help me move in 4 directions (up, down, left, right)
    int[] dcol = new int[] { 0, 0, -1, 1 };
    int[] drow = new int[] { -1, 1, 0, 0 };

    public int numIslands(char[][] grid) {
        int m = grid.length; // number of rows
        int n = grid[0].length; // number of columns
        int[][] vis = new int[m][n]; // visited array to mark visited land cells
        int count = 0; // will store number of islands

        // I’ll check every cell in the grid
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // if cell is land ('1') and not visited yet, it’s a new island
                if (vis[i][j] == 0 && grid[i][j] == '1') {
                    count++; // found a new island
                    dfs(grid, vis, i, j); // explore the whole connected land
                }
            }
        }

        return count; // total number of islands
    }

    // DFS to explore all connected land cells from (row, col)
    public void dfs(char[][] grid, int[][] vis, int row, int col) {
        vis[row][col] = 1; // mark current cell as visited

        int m = grid.length;
        int n = grid[0].length;

        // explore all 4 possible directions
        for (int i = 0; i < 4; i++) {
            int nrow = row + drow[i];
            int ncol = col + dcol[i];

            // check bounds before going to the next cell
            if (nrow >= 0 && nrow < m && ncol >= 0 && ncol < n) {
                // if next cell is unvisited and is land, continue DFS
                if (vis[nrow][ncol] == 0 && grid[nrow][ncol] == '1') {
                    dfs(grid, vis, nrow, ncol);
                }
            }
        }
    }
}
