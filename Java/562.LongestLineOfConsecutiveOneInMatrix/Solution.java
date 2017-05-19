public class Solution {
    public int longestLine(int[][] M) {
        if (M == null || M.length == 0 || M[0].length == 0) return 0;
        int width = M.length, height = M[0].length;

        int[][] horizontal = new int[width][height];
        int[][] vertical = new int[width][height];
        int[][] diagonal = new int[width][height];
        int[][] antiDiagonal = new int[width][height];
        int max = 0;
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                if (M[i][j] == 1) {
                    horizontal[i][j] = 1;
                    vertical[i][j] = 1;
                    diagonal[i][j] = 1;
                    antiDiagonal[i][j] = 1;
                    if (j > 0) horizontal[i][j] += horizontal[i][j-1];
                    if (i > 0) vertical[i][j] += vertical[i-1][j];
                    if (i > 0 && j > 0) diagonal[i][j] += diagonal[i-1][j-1];
                    if (i > 0 && j < width - 1) antiDiagonal[i][j] += antiDiagonal[i-1][j+1];
                    max = Math.max(Math.max(horizontal[i][j], vertical[i][j]), max);
                    max = Math.max(Math.max(diagonal[i][j], antiDiagonal[i][j]), max);
                }
            }
        }

        return max;
    }
}