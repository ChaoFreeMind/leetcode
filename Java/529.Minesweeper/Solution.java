// DFS
public class Solution {
    
    private static final int[][] DIRECTIONS = {
        {-1, -1}, {-1, 0}, {-1, 1}, 
        {0, 1}, {0, -1},
        {1, -1}, {1, 0}, {1, 1},
    };

    public char[][] updateBoard(char[][] board, int[] click) {
        dfs(board, click[0], click[1]);
        return board;
    }

    // 
    private void dfs(char[][] board, int i, int j) {
        // Return if coordinate is invalid or cell that is already updated. 
        if (!borderCheck(board, i, j) || (board[i][j] != 'M' && board[i][j] != 'E')) {
            return;
        }
        
        // If clicked on 'M', boom and return
        if (board[i][j] == 'M') {
            board[i][j] = 'X';
            return;
        }

        // If clicked on 'E', first check the number of adjacent mines
        int mineCount = countMine(board, i, j);

        // Update cell if the count of adjacent mines is positive
        if (mineCount > 0) {
            board[i][j] = (char)('0' + mineCount); 
        } else { // If no adjacent mines, update to 'B' and run dfs on adjacent cells recursively
            board[i][j] = 'B';
            for (int[] dir: DIRECTIONS) {
                dfs(board, i + dir[0], j + dir[1]);
            }
        }   
    }

    // Count and return the number of adjacent mines of a given cell.
    private int countMine(char[][] board, int i, int j) {
        int mineCount = 0;
        for (int[] dir: DIRECTIONS) {
            int rowIdx = i + dir[0], colIdx = j + dir[1];
            if (borderCheck(board, rowIdx, colIdx) && board[rowIdx][colIdx] == 'M') {
                mineCount++;
            }
        }
        return mineCount;
    }

    // Check if the given coordinate is valid
    private boolean borderCheck(char[][] board, int i, int j) {
        int row = board.length, col = board[0].length;
        return i >= 0 && i < row && j >= 0 && j < col;
    }
}