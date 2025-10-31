import java.util.*;

class Solution {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();

        // Edge case: empty matrix
        if (matrix == null || matrix.length == 0) return result;

        int top = 0; // starting row index
        int bottom = matrix.length - 1; // ending row index
        int left = 0; // starting column index
        int right = matrix[0].length - 1; // ending column index

        // Keep looping until all layers are traversed
        while (top <= bottom && left <= right) {
            //  Traverse from Left → Right along the top row
            for (int col = left; col <= right; col++) {
                result.add(matrix[top][col]);
            }
            top++; // Move top boundary down

            // Traverse from Top → Bottom along the right column
            for (int row = top; row <= bottom; row++) {
                result.add(matrix[row][right]);
            }
            right--; // Move right boundary left

            //  Traverse from Right → Left along the bottom row (only if still valid)
            if (top <= bottom) {
                for (int col = right; col >= left; col--) {
                    result.add(matrix[bottom][col]);
                }
                bottom--; // Move bottom boundary up
            }

            // Traverse from Bottom → Top along the left column (only if still valid)
            if (left <= right) {
                for (int row = bottom; row >= top; row--) {
                    result.add(matrix[row][left]);
                }
                left++; // Move left boundary right
            }
        }

        return result;
    }
}
