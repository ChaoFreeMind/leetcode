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
// Failed attempt
public class Solution {

    private int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private Map<String, boolean[]> map = new HashMap<>();

    // DFS
    public List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> resList = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return resList;
        final int ROW = matrix.length, COL = matrix[0].length;
        
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                dfs(matrix, i, j, resList);
            }
        }

        for (String key:map.keySet()) {
            boolean[] reachable = map.get(key);
            if (reachable[0] && reachable[1]) {
                resList.add(decode(key));
            }
        }

        return resList;
    }

    private boolean[] dfs(int[][] matrix, 
                          int row, 
                          int col, 
                          List<int[]> resList) {
        if (onBorder(matrix, row, col)) {
            boolean[] res = new boolean[2];
            if (row == 0 || col == 0) {
                res[0] = true;
            }    

            if (row == matrix.length - 1 || row == matrix[0].length - 1) {
                res[1] = true;
            }
            map.put(encode(row, col), res);
            return res;
        }

        boolean[] res = new boolean[2];

        for (int[] dir: dirs) {
            int adjRow = row + dir[0], adjCol = col + dir[1];
            // If current height is greater than or equal to adjacent cell, water can flow.
            if (matrix[row][col] >= matrix[adjRow][adjCol]) {
                String key = encode(adjRow, adjCol);
                boolean[] adjRes = null;

                if (!map.containsKey(key)) {
                    adjRes = dfs(matrix, adjRow, adjCol, resList);
                } else {
                    adjRes = map.get(key);
                }

                res[0] = res[0] || adjRes[0];
                res[1] = res[1] || adjRes[1];
            }
        }
        
        map.put(encode(row, col), res);

        return res;
    }


    // Check if the coordinate is on the border of a matrix
    private boolean onBorder(int[][] matrix, int i, int j) {
        return i == 0 || j == 0 || i == matrix.length - 1 || j == matrix[0].length - 1;
    }

    // Encode a coordinate (i, j) to "i,j"
    private String encode(int i, int j) {
        return i + "," + j;
    }

    private int[] decode(String s) {
        String[] parts = s.split(",");
        return new int[]{Integer.parseInt(parts[0]), Integer.parseInt(parts[1])};
    }
}