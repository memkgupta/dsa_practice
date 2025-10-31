class Solution {

    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int i = 0;
        int j = m - 1;
        while (i < n && j >= 0) {
            for (int l = 0; l <= j; l++) {
                swap(new int[] { i, l }, new int[] { n - 1 - l, j }, matrix);
            }
            i++;
            j--;
        }
        for (int col = 0; col < n; col++) {
            reverse(col, matrix);
        }
    }

    public void swap(int[] e1, int[] e2, int[][] matrix) {
        int temp = matrix[e1[0]][e1[1]];
        matrix[e1[0]][e1[1]] = matrix[e2[0]][e2[1]];
        matrix[e2[0]][e2[1]] = temp;
    }

    public void reverse(int j, int[][] matrix) {
        int i = 0;
        int l = matrix.length - 1;
        while (i < l) {
            swap(new int[] { i, j }, new int[] { l, j }, matrix);
            i++;
            l--;
        }
    }
}
