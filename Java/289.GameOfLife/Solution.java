//The in-place solution would be to use a 2 bits number to represent 4 states
	public void gameOfLife(int[][] board) {
		if(board == null || board.length == 0 || board[0].length == 0) return;
		int row = board.length, col = board[0].length; 
		for(int i = 0; i < row; i++) {
    		for(int j = 0; j < col; j++) {
    			int live = liveNeighbors(board, i, j);
    			//Rule 1
    			if((board[i][j] & 1) == 1 && live < 2) board[i][j] = 1;
    			//Rule 2 does not include state change
    			if((board[i][j] & 1) == 1 && (live == 2 || live == 3)) board[i][j] = 3;
    			//Rule 3
    			if((board[i][j] & 1) == 1 && live > 3) board[i][j] = 1; 
    			//Rule 4
    			if(board[i][j] == 0 && live == 3) board[i][j] = 2;
    		}
    	}
		
		//Change to next stage
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < col; j++) {
				board[i][j] >>= 1;
			}
		}
	}
	
	//Original O(m*n) space solution trivial
    /*public void gameOfLife(int[][] board) {
    	if(board == null || board.length == 0 || board[0].length == 0) return;
    	int row = board.length, col = board[0].length; 
    	boolean[][] mark = new boolean[row][col];
    	for(int i = 0; i < row; i++) {
    		for(int j = 0; j < col; j++) {
    			int live = liveNeighbors(board, i, j);
    			//Rule 1
    			if(board[i][j] == 1 && live < 2) mark[i][j] = true;
    			//Rule 2 does not include state change
    			//Rule 3
    			if(board[i][j] == 1 && live > 3) mark[i][j] = true;
    			//Rule 4
    			if(board[i][j] == 0 && live == 3) mark[i][j] = true;
    		}
    	}
    	
    	//Flip all board according to mark array
    	for(int i = 0; i < row; i++) {
    		for(int j = 0; j < col; j++) {
    			if(mark[i][j]) board[i][j] = (board[i][j] == 1) ? 0 : 1;
    		}
    	}
    	
    } */
    
    private int liveNeighbors(int[][] board, int x, int y) {
    	int live = 0;
    	int row = board.length, col = board[0].length;
    	int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};
    	for(int i = 0; i < dir.length; i++) {
    		int px = x + dir[i][0];
    		int py = y + dir[i][1];
    		if(px >= 0 && px < row && py >= 0 && py < col) live += (board[px][py] & 1);
    	}
    	return live;
    }