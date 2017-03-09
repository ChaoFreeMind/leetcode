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

    // DFS
    public List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> resList = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return resList;
        final int ROW = matrix.length, COL = matrix[0].length;
        boolean[][] pacific = new boolean[ROW][COL];
        boolean[][] atlantic = new boolean[ROW][COL];

        for (int i = 0; i < ROW; i++) {
            dfs(matrix, pacific, Integer.MIN_VALUE, i, 0);
            dfs(matrix, atlantic, Integer.MIN_VALUE, i, COL - 1);
        }

        for (int j = 0; j < COL; j++) {
            dfs(matrix, pacific, Integer.MIN_VALUE, 0, j);
            dfs(matrix, atlantic, Integer.MIN_VALUE, ROW - 1, j)
        }

        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    resList.add(new int[]{i, j});
                }
            }
        }

        return resList;
    }

    private void dfs(int[][] matrix, boolean[][] visited, int prevHeight, int i, int j) {
        if (!isValid(matrix, i, j) || visited[i][j] || prevHeight > matrix[i][j]) {
            // Invalid cases
            return ;
        }
        visited[i][j] = true;
        for (int[] dir: dirs) {
            dfs(matrix, visited, matrix[i][j], i + dir[0], j + dir[1]);
        }
    }

    // Check if the coordinate is on the border of a matrix
    private boolean isValid(int[][] matrix, int i, int j) {
        return i >= 0 && j >= 0 && i < matrix.length && j < matrix[0].length;
    }
}