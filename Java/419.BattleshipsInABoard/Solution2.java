public class Solution {
    public int countBattleships(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) return 0;

        int row = board.length, col = board[0].length;
        int count = 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (check(board, i, j)) {
                    count++;
                } 
            }
        }

        return count;
    }

    private boolean check(char[][] board, int i, int j) {
        return board[i][j] == 'X' 
            && (i == 0 || i != 0 && board[i - 1][j] == '.')
            && (j == 0 || j != 0 && board[i][j - 1] == '.');
    }
}