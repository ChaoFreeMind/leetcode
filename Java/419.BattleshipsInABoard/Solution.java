public class Solution {
	// Not so clean but straight-forward solution:
	// Go through the board, when we see an X, mark it with 'O' along with all four directions.
    // public int countBattleships(char[][] board) {
    // 	int row = board.length, col = board[0].length;
    // 	int count = 0;
    // 	for (int i = 0; i < row; i++) {
    // 		for (int j = 0; j < col; j++) {
    // 			if (board[i][j] == 'X') {
    // 				// Check all four directions, and remove battle ship.
    // 				markBattleShip(i, j, board);
    // 				count++;
    // 			}
    // 		}
    // 	}
    	
    // 	restoreBattleShip(board);
    	
    // 	return count;
    // }
    
    // private void restoreBattleShip(char[][] board) {
    //     int row = board.length, col = board[0].length;
    //     for (int i = 0; i < row; i++) 
    //         for (int j = 0; j < col; j++) 
    //             if (board[i][j] == 'O') board[i][j] = 'X';
    // }
    
    // private void markBattleShip(int x, int y, char[][] board) {
    // 	int row = board.length, col = board[0].length;
    // 	int i = x - 1, j = y;
    // 	while (i >= 0 && board[i][j] == 'X') {
    // 	    board[i][j] = 'O';
    // 	    i--;
    // 	}

    // 	i = x + 1; 
    // 	j = y;
    // 	while (i < row && board[i][j] == 'X') {
    // 	    board[i][j] = 'O';
    // 	    i++;
    // 	}

    // 	i = x;
    // 	j = y - 1;
    // 	while (j >= 0 && board[i][j] == 'X') {
    // 	    board[i][j] = 'O';
    // 	    j--;
    // 	}

    // 	i = x;
    // 	j = y + 1;
    // 	while (j < col && board[i][j] == 'X') {
    // 	    board[i][j] = 'O';
    // 	    j++;
    // 	}
    // }

	public int countBattleships(char[][] board) {
		int row = board.length, col = board[0].length;
		int count = 0;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (board[i][j] == 'X' && (i == 0 || board[i-1][j] == '.') && (j == 0 || board[i][j-1] == '.')) {
					count++;
				}
			}
		}

		return count;
	}
}