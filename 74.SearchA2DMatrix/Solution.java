public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
    	//2d Binary search
    	//Corner case check
    	if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
    		return false;
    	int m = matrix.length, n = matrix[0].length;
    	
    	//First decide which row our target lands in
    	int top = 0, bottom = m - 1;
    	int row = -1;
    	while(bottom >= top) {
    		int mid = top + (bottom - top) / 2;
    		if(target >= matrix[mid][0] && target <= matrix[mid][n-1]) {
    			//target lands in row mid
    			row = mid;
    			break;
    		} else if(target > matrix[mid][n-1]) {
    			top = mid + 1;
    		} else {//target < matrix[mid][0]
    			bottom = mid - 1;
    		}
    	}
    	//Can not get which row target number lands.
    	if(row == -1) return false;
    	
    	int left = 0, right = n - 1;
    	
    	while (left <= right) {
    		int mid = left + (right - left) / 2;
    		if(target == matrix[row][mid]) {
    			return true;
    		} else if(target < matrix[row][mid]) {
    			right = mid - 1;
    		} else {//target > matrix[row][mid]
    			left = mid + 1;
    		}
    	}
    	
        return false;
    }
}