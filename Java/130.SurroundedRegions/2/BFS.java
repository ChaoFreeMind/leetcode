public class Solution {
	class Cell {
		int x; //Row
		int y; //Col
		Cell(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	//By observation: We can see that all 'O' sitting on the edges of the board is not
	//affected, so we can run BFS/DFS on each one of them and then mark them as 'M'
	//Finally scan the board, if we see 'M', flip it to 'O', when we see 'O', replace them with 'X'
	public void solve(char[][] board) {
		//Invalid board
		if(board == null || board.length == 0 || board[0].length == 0) return;
		int row = board.length, col = board[0].length;
		Deque<Cell> queue = new LinkedList<>();
		//Scan left and right edge
		for(int i = 0; i < row; i++) {
			//Left i, 0
			if(board[i][0] == 'O') {
				board[i][0] = 'M';
				queue.offer(new Cell(i, 0));
			}
			//Right i, col - 1
			if(board[i][col-1] == 'O') {
				board[i][col - 1] = 'M';
				queue.offer(new Cell(i, col - 1));
			}
		}

		//Scan top and bottom edge
		for(int j = 0; j < col; j++) {
			//Top 0, j
			if(board[0][j] == 'O') {
				board[0][j] = 'M';
				queue.offer(new Cell(0, j));
			}
			//Bottom row-1, j
			if(board[row-1][j] == 'O') {
				board[row-1][j] = 'M';
				queue.offer(new Cell(row-1, j));
			}
		}
		int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
		while(!queue.isEmpty()) {
			Cell cell = queue.poll();
			for(int i = 0; i < dir.length; i++) {
				int x = cell.x + dir[i][0];
				int y = cell.y + dir[i][1];
				if(check(board, x, y) && board[x][y] == 'O') {
					board[x][y] = 'M';
					queue.offer(new Cell(x, y));
				}
			}
		}

 	
 		//Flip all 'O' to X and 'M' to 'O'
 		for(int i = 0; i < row; i++) {
 			for(int j = 0; j < col; j++) {
 				if(board[i][j] == 'O') {
 					board[i][j] = 'X';
 				} else if(board[i][j] == 'M') {
 					board[i][j] = 'O';
 				}

 			}
 		}
	}

	/*
	private void bfs(char[][] board, Cell start) {
		//queue for BFS
		Deque<Cell> queue = new LinkedList<>();
		queue.offer(start);
		int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
		while(!queue.isEmpty()) {
			Cell cell = queue.poll();
			board[cell.x][cell.y] = 'M';
			//Check four directions as potencial next steps
			for(int i = 0; i < dir.length; i++) {
				int x = cell.x + dir[i][0];
				int y = cell.y + dir[i][1];
				if(check(board, x, y) && board[x][y] == 'O') {
					queue.offer(new Cell(x, y));
				}
			}
		}
	}*/

	private boolean check(char[][] board, int x, int y) {
		int row = board.length, col = board[0].length;
		return x >= 0 && x < row && y >= 0 && y < col
	}
}