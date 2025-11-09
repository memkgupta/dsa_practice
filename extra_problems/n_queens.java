class Solution {

    int count = 0;

    public int totalNQueens(int n) {
        int[][] board = new int[n][n];
        helper(board, 0, n); // start from row 0
        return count;
    }

    public void helper(int[][] board, int row, int n) {
        if (row == n) {
            count++;
            return;
        }

        for (int col = 0; col < n; col++) {
            if (canPlace(board, row, col)) {
                board[row][col] = 1;
                helper(board, row + 1, n);
                board[row][col] = 0;
            }
        }
    }

    public boolean canPlace(int[][] board, int row, int col) {
        int n = board.length;

        // check column
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 1) return false;
        }

        // check diagonals
        for (int i = 0; i < row; i++) {
            int diff = row - i;
            if (col - diff >= 0 && board[i][col - diff] == 1) return false;
            if (col + diff < n && board[i][col + diff] == 1) return false;
        }

        return true;
    }
}
