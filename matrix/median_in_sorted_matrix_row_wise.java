// Problem statement Median in a row-wise sorted Matrix
class Solution {

    public int median(int[][] mat) {
        // code here
        int m = mat.length;
        int n = mat[0].length;
        int[] row = new int[m * n];
        int[] indexes = new int[m];
        for (int i = 0; i < row.length; i++) {
            int min = Integer.MAX_VALUE;
            int index = -1;
            for (int r = 0; r < m; r++) {
                int r_i = indexes[r];
                if (r_i < n && mat[r][r_i] < min) {
                    index = r;
                    min = mat[r][r_i];
                }
            }
            row[i] = min;
            indexes[index]++;
        }

        return row[row.length / 2];
    }
}
