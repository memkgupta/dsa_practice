class Solution {

    public boolean searchMatrix(int[][] matrix, int target) {
        // Get number of rows (m) and columns (n)
        int m = matrix.length;
        int n = matrix[0].length;

        // Binary search over rows
        int r_start = 0;
        int r_end = m - 1;

        while (r_start <= r_end) {
            // Find middle row
            int mid = (r_start + r_end) / 2;

            // Case 1: Target is equal to the last element of mid row
            if (matrix[mid][n - 1] == target) {
                return true;
            }
            // Case 2: Target is greater than last element of mid row
            // → So it must be in rows below
            else if (matrix[mid][n - 1] < target) {
                r_start = mid + 1;
            }
            // Case 3: Target is smaller than last element of mid row
            else {
                // Check if target could be in this row:
                // if target is >= first element and <= last element of this row
                if (matrix[mid][0] <= target) {
                    // Binary search within this specific row
                    int c_start = 0;
                    int c_end = n - 1;
                    while (c_start <= c_end) {
                        int c_mid = (c_start + c_end) / 2;

                        // If element found
                        if (matrix[mid][c_mid] == target) {
                            return true;
                        }
                        // Move right
                        else if (matrix[mid][c_mid] < target) {
                            c_start = c_mid + 1;
                        }
                        // Move left
                        else {
                            c_end = c_mid - 1;
                        }
                    }
                }
                // If not found in this row, look in the rows above
                r_end = mid - 1;
            }
        }

        // Target not found anywhere in the matrix
        return false;
    }
}
