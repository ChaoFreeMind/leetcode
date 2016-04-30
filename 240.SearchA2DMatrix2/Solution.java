public class Solution {
    //2 binary searches, first one locate the row, second one locate the column
    public boolean searchMatrix(int[][] matrix, int target) {
    	if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
    	int row = matrix.length, col = matrix[0].length;
    	int i = 0, j = col - 1;
    	
    	while(i < row && j >= 0) {
    		if(target == matrix[i][j]) {
    			return true;
    		} else if(target > matrix[i][j]) {
    			i++;
    		} else {//target < matrix[i][j]
    			j--;
    		}
    	}
    	return false;
    }
}