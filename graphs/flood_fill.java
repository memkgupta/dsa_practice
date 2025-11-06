class Solution {

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m = image.length; // total rows
        int n = image[0].length; // total columns (fixed your small typo: was using image.length)

        // I could use a visited array, but not needed since I directly modify 'image'
        int[] delrow = { -1, 0, 1, 0 }; // row movement → up, left, down, right
        int[] delcol = { 0, -1, 0, 1 }; // column movement

        // I’ll start DFS from (sr, sc) with the original color as reference
        dfs(image, delrow, delcol, sr, sc, color, image[sr][sc]);
        return image; // return modified image
    }

    // DFS function to spread color in all 4 connected directions
    public void dfs(
        int[][] image,
        int[] delrow,
        int[] delcol,
        int row,
        int col,
        int color,
        int inicolor
    ) {
        // recolor the current cell
        image[row][col] = color;

        int m = image.length;
        int n = image[0].length;

        // explore all 4 directions
        for (int i = 0; i < delrow.length; i++) {
            int nrow = row + delrow[i];
            int ncol = col + delcol[i];

            // check bounds + make sure the next cell is the same initial color
            // also ensure we don’t recolor already painted cells
            if (
                nrow >= 0 &&
                nrow < m &&
                ncol >= 0 &&
                ncol < n &&
                image[nrow][ncol] == inicolor &&
                image[nrow][ncol] != color
            ) {
                // recursively color connected region
                dfs(image, delrow, delcol, nrow, ncol, color, inicolor);
            }
        }
    }
}

// (Not used here, but could be handy for BFS version)
class Pair {

    int first;
    int second;

    Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}
