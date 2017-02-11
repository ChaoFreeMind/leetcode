// My original solution.
public class Solution {
    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return new int[0];
        int row = matrix.length;
        int col = matrix[0].length;

        int[] res = new int[row * col];
        List<Integer> resList = new ArrayList<>();

        int[] start = {0, 0};
        // For a M * N matrix, the total round of diagnal iterations would be (M + N - 1)
        for (int i = 0; i < row + col - 1; i++) {
            if (i % 2 == 0) {
                start = diagnalUpward(resList, start[0], start[1], matrix);
            } else {
                start = diagnalDownward(resList, start[0], start[1], matrix);
            }
        }

        // Convert resList to res
        return convertIntListToArray(resList);
    }
    /**
     * Starting from rowIdx and colIdx iterate diagnally upwards and put each elements into the res
     * return the starting index of the next iteration
     */
    private int[] diagnalUpward(List<Integer> resList, int rowIdx, int colIdx, int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;

        while ((rowIdx >= 0 && rowIdx < row) && (colIdx >= 0 && colIdx < col)) {
            resList.add(matrix[rowIdx][colIdx]);
            rowIdx--;
            colIdx++;
        }
        rowIdx++;
        colIdx--;
        // Compute new starting point: try to go right, if reaches the end then go down.
        if (colIdx == col - 1) return new int[]{rowIdx + 1, colIdx};
        return new int[]{rowIdx, colIdx + 1};
    }

    private int[] diagnalDownward(List<Integer> resList, int rowIdx, int colIdx, int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;

        while ((rowIdx >= 0 && rowIdx < row) && (colIdx >= 0 && colIdx < col)) {
            resList.add(matrix[rowIdx][colIdx]);
            rowIdx++;
            colIdx--;
        }
        rowIdx--;
        colIdx++;
        // Compute new starting point: try to go down, if reaches the end, go right.
        if (rowIdx == row - 1) return new int[]{rowIdx, colIdx + 1};
        return new int[]{rowIdx + 1, colIdx};
    }

    private int[] convertIntListToArray(List<Integer> list) {
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}