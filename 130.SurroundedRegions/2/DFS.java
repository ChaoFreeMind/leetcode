public class Solution {
	public void solve(char[][] board) {
		//Invalid cases
		if(board == null || board.length == 0 || board[0].length == 0) return;
		int row = board.length, col = board[0].length;
		for(int i = 0; i < row; i++) {
			//left edge
			if(board[i][0] == 'O') {
				board[i][0] = 'M';
				dfs(board, i, 0);
			}
			//right edge
			if(board[i][col-1] == 'O') {
				board[i][col-1] = 'M';
				dfs(board, i, col-1);
			}
		}

		for(int j = 0; j < col; j++) {
			//Top edge
			if(board[0][j] == 'O') {
				board[0][j] = 'M';
				dfs(board, 0, j);
			}

			//Bottom edge
			if(board[row-1][j] == 'O') {
				board[row-1][j] = 'M';
				dfs(board, row-1, j);
			}
		}

		for(int i = 0; i < row; i++) {
			for(int j = 0; j < col; j++) {
				if(board[i][j] == 'M') {
					board[i][j] = 'O';
				} else if(board[i][j] == 'O') {
					board[i][j] = 'X';
				}
			}
		}
	}

	//The tricky part is to skip the borders!!
	private void dfs(int[][] board, int i, int j) {
		int row = board.length, col = board[0].length;
		//Almost stack overflow, do not include borders, or it will be more 2*stack_size
		if(i+1 < row-1 && board[i+1][j] == 'O') {
			board[i+1][j] = 'M';
			dfs(board, i+1, j);
		}

		if(i-1 > 0 && board[i-1][j] == 'O') {
			board[i-1][j] = 'M';
			dfs(board, i-1, j);
		}

		if(j+1 < col-1 && board[i][j+1] == 'O') {
			board[i][j+1] = 'M';
			dfs(board, i, j+1);
		}

		if(j-1 > 0 && board[i][j-1] == 'O') {
			board[i][j-1] = 'M';
			dfs(board, i, j-1);
		}
	}
}