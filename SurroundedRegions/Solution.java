import java.util.ArrayDeque;
import java.util.Deque;

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
    
    public void solve(char[][] board) {
        
        int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        Deque<int[]> queue = new ArrayDeque<>();
        
        int row = board.length;
        int col = board[0].length;
        
        //Add all four borders
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if(i == 0 || j == 0 || i == row - 1 || j == col - 1)
                    queue.add(new int[]{i, j});
            }
        }
        
        while(!queue.isEmpty()) {
            int[] point = queue.poll();
            board[point[0]][point[1]] = 'M';
            for(int i = 0; i < dir.length; i++) {
                int m = point[0] + dir[i][0];
                int n = point[1] + dir[i][1];
                if(m >= 0 && n < row && n >= 0 && n < col && board[m][n] == 'O') {
                    //if m and n is a valid position on board and it is an 'O' add it into our queue
                    queue.add(new int[]{m, n});
                }
            }
        }
        //Scan the board
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
}
