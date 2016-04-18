import java.util.Deque;
import java.util.LinkedList;

//Given a 2D board containing 'X' and 'O', capture all regions surrounded by 'X'.
//
//A region is captured by flipping all 'O's into 'X's in that surrounded region.
//
//For example,
//X X X X
//X O O X
//X X O X
//X O X X
//After running your function, the board should be:
//
//X X X X
//X X X X
//X X X X
//X O X X
public class Solution {
	
	static class Pair {
		int x;
		int y;
		Pair(int i, int j) {
			x = i;
			y = j;
		}
	}
	//We can see by observation that all 'O' sitting right on the border of the board 
	//will not be flipped, so we run BFS on one of them and mark them '*', those 'O's that are 
	//not been marked will have to be flipped, when we met '*' just change it back to 'O'.
    public void solve(char[][] board) {
        //Invalid board
    	if(board == null || board.length == 0 || board[0].length == 0) return;
    	Deque<Pair> queue = new LinkedList<>();
    	int row = board.length, col = board[0].length;
    	//Go through the boarder, when we see a 'O', run BFS on it
    	for(int i = 0; i < board.length; i++) {
    		if(board[i][0] == 'O') {
    			board[i][0] = '*';
    			queue.offer(new Pair(i, 0));
    		}
    		if(board[i][col - 1] == 'O') {
    			board[i][col - 1] = '*';
    			queue.offer(new Pair(i, col - 1));
    		}
    	}
    	
    	for(int j = 0; j < col; j++) {
    		if(board[0][j] == 'O') {
    			board[0][j] = '*';
    			queue.offer(new Pair(0, j));
    		}
    		if(board[row - 1][j] == 'O') {
    			board[row-1][j] = '*';
    			queue.offer(new Pair(row - 1, j));
    		}
    	}
    	
    	while(!queue.isEmpty()) {
    		Pair p = queue.poll();
    		int x = p.x, y = p.y;
    		if(x-1 >= 0 && board[x-1][y] == 'O') {
    			board[x-1][y] = '*';
    			queue.offer(new Pair(x-1, y));
    		}
    		if(x+1 < row && board[x+1][y] == 'O') {
    			board[x+1][y] = '*';
    			queue.offer(new Pair(x+1, y));
    		}
    		if(y+1 < col && board[x][y+1] == 'O') {
    			board[x][y+1] = '*';
    			queue.offer(new Pair(x, y+1));
    		}
    		if(y-1 >= 0 && board[x][y-1] == 'O') {
    			board[x][y-1] = '*';
    			queue.offer(new Pair(x, y - 1));
    		}
    	}
    	//Flip all * to O and O to X
    	for(int i = 0; i < board.length; i++) {
    		for(int j = 0; j < board[0].length; j++) {
    			if(board[i][j] == '*') board[i][j] = 'O';
    			if(board[i][j] == 'O') board[i][j] = 'X';
    		}
    	}
    	
    }
    //Iterative
//    private void bfs(char[][] board, int i, int j) {
//    	int row = board.length, col = board[0].length;
//    	if(i < 0 || j < 0 || i >= row || j >= col) return;
//    	if(board[i][j] == 'O') {
//    		Deque<Pair> queue = new LinkedList<>();
//        	queue.offer(new Pair(i, j));
//        	while(!queue.isEmpty()) {
//        		Pair p = queue.poll();
//        		board[p.x][p.y] = '*';
//        		Pair up = new Pair(p.x - 1, p.y);
//        		Pair down = new Pair(p.x + 1, p.y);
//        		Pair left = new Pair(p.x, p.y - 1);
//        		Pair right = new Pair(p.x, p.y + 1);
//        		if(isValidPair(up, board)) queue.offer(up);
//        		if(isValidPair(down, board)) queue.offer(down);
//        		if(isValidPair(left, board)) queue.offer(left);
//        		if(isValidPair(right, board)) queue.offer(right);
//        	}
//    	}
//    }
    
    private boolean isValidPair(Pair p, char[][] board) {
    	return p.x >= 0 && p.y >= 0 && p.x < board.length && p.y < board[0].length && board[p.x][p.y] == 'O'; 
    }
    
    //Stack overflow
//    private void bfs(char[][] board, int i, int j) {
//    	int row = board.length, col = board[0].length;
//    	if(i < 0 || j < 0 || i >= row || j >= col) return;
//    	if(board[i][j] == 'O') {
//    		board[i][j] = '*';
//        	bfs(board, i + 1 , j + 1);
//        	bfs(board, i + 1, j - 1);
//        	bfs(board, i - 1, j - 1);
//        	bfs(board, i - 1, j + 1);
//    	}
//    }
    
}