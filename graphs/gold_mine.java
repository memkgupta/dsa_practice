class Solution {

    int[] dcol = { 1, 1, 1 };
    int[] drow = { -1, 1, 0 };
    int[][] dp;

    public int maxGold(int[][] mat) {
        // code here
        dp = new int[mat.length][mat[0].length];
        for (int[] d : dp) {
            Arrays.fill(d, -1);
        }
        int max = 0;
        for (int i = 0; i < mat.length; i++) {
            max = Math.max(max, rec(mat, i, 0));
        }
        return max;
    }

    public int rec(int[][] mat, int i, int j) {
        int m = mat.length;
        int n = mat[0].length;
        if (dp[i][j] != -1) return dp[i][j];
        int max = 0;
        for (int l = 0; l < 3; l++) {
            int nrow = i + drow[l];
            int ncol = j + dcol[l];
            if (nrow >= 0 && nrow < m && ncol >= 0 && ncol < n) {
                max = Math.max(max, rec(mat, nrow, ncol));
            }
        }
        return dp[i][j] = max + mat[i][j];
    }
}
