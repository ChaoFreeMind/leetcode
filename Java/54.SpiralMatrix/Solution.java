import java.util.ArrayList;
import java.util.List;

public class Solution {
	
    public List<Integer> spiralOrder(int[][] matrix) {
    	List<Integer> resList = new ArrayList<>();
    	if(matrix == null || matrix.length == 0 || matrix[0].length == 0) 
    		return resList;
    	
    	int m = matrix.length, n = matrix[0].length;//m rows n cols
    	int top = 0, bottom = m - 1, left = 0, right = n - 1;
    	while(boundaryCheck(top, bottom, right, left)) {
    		//Move from left to right
    		for(int col = left; col <= right; col++) {
    			resList.add(matrix[top][col]);
    		}
    		top++;
    		
    		if(top > bottom) break;
    		
    		//Move from top to bottom
    		for(int row = top; row <= bottom; row++) {
    			resList.add(matrix[row][right]);
    		}
    		right--;
    		
    		if(right < left) break;
    		
    		//Move from right to left
    		for(int col = right; col >= left; col--) {
    			resList.add(matrix[bottom][col]);
    		}
    		bottom--;
    		
    		if(top > bottom) break;
    		
    		//Move from bottom to top
    		for(int row = bottom; row >= top; row++) {
    			resList.add(matrix[row][left]);
    		}
    		left++;
    		
    	}
    	
    	return resList;
    }
    
    private boolean boundaryCheck(int top, int bottom, int right, int left) {
    	return top <= bottom && left <= right;
    }
    
}