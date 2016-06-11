public class NumMatrix {

	private int[][] sum;//sum[i][j] means the sum of rectangle from 0,0 to i,j

    public NumMatrix(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return;
        int row = matrix.length, col = matrix[0].length;
        sum = new int[row][col];
        sum[0][0] = matrix[0][0];
        //Initialize first col
        for(int i = 1; i < row; i++) {
        	sum[i][0] = sum[i-1][0] + matrix[i][0];
        }
        //Initialize first row
        for(int j = 1; j < col; j++) {
        	sum[0][j] = sum[0][j-1] + matrix[0][j];
        }

        for(int i = 1; i < row; i++) {
        	for(int j = 1; j < col; j++) {
        		sum[i][j] = matrix[i][j] + sum[i-1][j] + sum[i][j-1] - sum[i-1][j-1];
        	}
        }

    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if(row1 == 0 && col1 == 0) {
            return sum[row2][col2];
        } else if(row1 > 0 && col1 > 0) {
            return sum[row2][col2] - sum[row2][col1-1] - sum[row1-1][col2] + sum[row1-1][col1-1];
        } else if(row1 == 0) {//col1 > 0
            return sum[row2][col2] - sum[row2][col1-1];
        } else {
            return sum[row2][col2] - sum[row1-1][col2];
        }
    }
}


// Your NumMatrix object will be instantiated and called as such:
// NumMatrix numMatrix = new NumMatrix(matrix);
// numMatrix.sumRegion(0, 1, 2, 3);
// numMatrix.sumRegion(1, 2, 3, 4);