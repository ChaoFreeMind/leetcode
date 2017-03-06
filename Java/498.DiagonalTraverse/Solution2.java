public class Solution {

    // Going upward: row - 1, col + 1
    // Going downward: row + 1, col - 1;
    // If reached top / bottom, col + 1
    // If reached left / right, row + 1
    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return new int[0];
        int row = matrix.length;
        int col = matrix[0].length;
        int[] res = new int[row * col];

        int[][] dir = {{-1, 1}, {1, -1}}; // dir[0] upwards, dir[1] downwards
        int r = 0, c = 0; // r: row index c: column index
        int direction = 0; // 0 upwards, 1 downwards

        for (int i = 0; i < row * col; i++) {

            res[i] = matrix[r][c];

            // When reach the boundary, switch direction
            r += dir[direction][0];
            c += dir[direction][1];

            // Check if r and c has been out of the boundary

            // Bottom
            if (r >= row) {
                r--;
                c += 2;
                d = 1 - d;
            }
            // Right
            if (c >= col) {
                c--;
                r += 2;
                d = 1 - d;
            }

            // Top
            // If both top and right boundary are invalid, only do right 
            if (c < col && r < 0) {
                r = 0;
                // Reverse direction
                d = 1 - d;
            }
            // Left
            // If both bottom and left boundary are invalid, only do left
            if (r < row && c < 0) {
                c = 0;
                d = 1 - d;
            }
        }

        return res;
    }
}