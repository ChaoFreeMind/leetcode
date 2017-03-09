// Given an m x n matrix of non-negative integers representing the height of each unit cell in a 
// continent, the "Pacific ocean" touches the left and top edges of the matrix and the 
// "Atlantic ocean" touches the right and bottom edges.

// Water can only flow in four directions (up, down, left, or right) from a cell to another one with
// height equal or lower.

// Find the list of grid coordinates where water can flow to both the Pacific and Atlantic ocean.

// Note:
// The order of returned grid coordinates does not matter.
// Both m and n are less than 150.
// Example:

// Given the following 5x5 matrix:

//   Pacific ~   ~   ~   ~   ~ 
//        ~  1   2   2   3  (5) *
//        ~  3   2   3  (4) (4) *
//        ~  2   4  (5)  3   1  *
//        ~ (6) (7)  1   4   5  *
//        ~ (5)  1   1   2   4  *
//           *   *   *   *   * Atlantic

// Return:

// [[0, 4], [1, 3], [1, 4], [2, 2], [3, 0], [3, 1], [4, 0]] (positions with parentheses in above matrix).

public class Solution {

    private int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    // BFS
    public List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> resList = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return resList;
        final int ROW = matrix.length, COL = matrix[0].length;
        boolean[][] pacific = new boolean[ROW][COL];
        boolean[][] atlantic = new boolean[ROW][COL];
        Deque<int[]> pq = new Deque<>();
        Deque<int[]> aq = new Deque<>(); 

        for (int i = 0; i < ROW; i++) {
            pq.offer(new int[]{i, 0});
            aq.offer(new int[]{i, COL - 1});
            // all elements in
        }

        for (int j = 0; j < COL; j++) {
            pq.offer(new int[]{0, j});
            aq.offer(new int[]{0, ROW - 1});
        }

        bfs(matrix, pacific, pq);
        bfs(matrix, atlantic, aq);

        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    resList.add(new int[]{i, j});
                }
            }
        }

        return resList;
    }

    private void bfs(int[][] matrix, boolean[][] visited, Deque<int[]> queue) {
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            visited[cur[0]][cur[1]] = true;
            for (int[] dir: dirs) {
                int adjRow = cur[0] + dir[0];
                int adjCol = cur[1] + dir[1];
                if (isValid(matrix, adjRow, adjCol) && matrix[cur[0]][cur[1]] <= matrix[adjRow][adjCol] && !visited[i][j]) {
                    queue.offer(new int[]{adjRow, adjCol});
                }
            }
        }
    }

    // Check if the coordinate is on the border of a matrix
    private boolean isValid(int[][] matrix, int i, int j) {
        return i >= 0 && j >= 0 && i < matrix.length && j < matrix[0].length;
    }
}