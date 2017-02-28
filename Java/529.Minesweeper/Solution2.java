// BFS
public class Solution {
    
    private static final int[][] DIRECTIONS = {
        {-1, -1}, {-1, 0}, {-1, 1}, 
        {0, 1}, {0, -1},
        {1, -1}, {1, 0}, {1, 1},
    };

    public char[][] updateBoard(char[][] board, int[] click) {
        bfs(board, click[0], click[1]);
        return board;
    }

    private void bfs(char[][] board, int i, int j) {
        
        Deque<int[]> queue = new LinkedList();

        queue.offer(new int[]{i, j});
        
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int row = cell[0], col = cell[1];
            // Clicked on bomb
            if (board[row][col] == 'M') {
                board[row][col] = 'X';
                return;
            } else { // Empty cell
                int mineCount = countMine(board, row, col);
                if (mineCount == 0) {
                    // Add adjacent cells into the queue
                    board[row][col] = 'B';
                    for (int[] dir: DIRECTIONS) {
                        int rowIdx = row + dir[0], colIdx = col + dir[1];
                        if (borderCheck(board, rowIdx, colIdx) && board[rowIdx][colIdx] == 'E') {
                            queue.offer(new int[]{rowIdx, colIdx});
                            // We need to mark it in order not to add it twice.
                            board[rowIdx][colIdx] = 'B';
                        }
                    }
                } else {
                    board[row][col] = (char)('0' + mineCount);
                }
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