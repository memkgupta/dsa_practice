class Solution {

    // final response which is a global variable
    List<List<String>> lst = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        int[][] board = new int[n][n];
        helper(board, 0, n); // start from row 0
        return lst;
    }

    // helper function
    public void helper(int[][] board, int row, int n) {
        // base condition all rows checked
        if (row == n) {
            List<String> l = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    sb.append(board[i][j] == 1 ? 'Q' : '.');
                }
                l.add(sb.toString());
            }
            lst.add(l);
            return;
        }
        // for each row checking every colum if can put a queen here
        //  and after putting the queen recursiveley check for rest of places and then backtrack
        for (int col = 0; col < n; col++) {
            if (canPlace(board, row, col)) {
                board[row][col] = 1;
                helper(board, row + 1, n);
                board[row][col] = 0;
            }
        }
    }

    // function for checking wether the queen can be placed there or not
    public boolean canPlace(int[][] board, int row, int col) {
        int n = board.length;

        // check column , if in the same colum a queen is present can't place the queen
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
