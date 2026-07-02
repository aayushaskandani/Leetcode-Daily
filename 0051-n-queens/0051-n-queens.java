class Solution {

    public List<List<String>> solveNQueens(int n) {

        List<List<String>> ans = new ArrayList<>();

        char[][] board = new char[n][n];

        // Fill the board with '.'
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        helper(0, board, ans, n);

        return ans;
    }

    private void helper(int row, char[][] board, List<List<String>> ans, int n) {

        // Base case: All queens placed
        if (row == n) {
            ans.add(construct(board));
            return;
        }

        // Try placing queen in every column
        for (int col = 0; col < n; col++) {

            if (isSafe(board, row, col, n)) {

                board[row][col] = 'Q';      // Choose

                helper(row + 1, board, ans, n); // Explore

                board[row][col] = '.';      // Backtrack
            }
        }
    }

    private boolean isSafe(char[][] board, int row, int col, int n) {

        // Check same column
        int r = row;
        while (r >= 0) {
            if (board[r][col] == 'Q')
                return false;
            r--;
        }

        // Check upper-left diagonal
        r = row;
        int c = col;

        while (r >= 0 && c >= 0) {
            if (board[r][c] == 'Q')
                return false;
            r--;
            c--;
        }

        // Check upper-right diagonal
        r = row;
        c = col;

        while (r >= 0 && c < n) {
            if (board[r][c] == 'Q')
                return false;
            r--;
            c++;
        }

        return true;
    }

    private List<String> construct(char[][] board) {

        List<String> temp = new ArrayList<>();

        for (int i = 0; i < board.length; i++) {
            temp.add(new String(board[i]));
        }

        return temp;
    }
}