public int[][] generateMatrix(int n) { 
		int[][] matrix = new int[n][n];
		
		int top = 0, bottom = n - 1, left = 0, right = n - 1;
		int val = 1;
		while(top <= bottom && left <= right) {
			//Move from left to right
			for(int col = left; col <= right; col++)
				matrix[top][col] = val++;
			top++;
			
			//Move from top to bottom
			for(int row = top; row <= bottom; row++)
				matrix[row][right] = val++;
			right--;
			
			if(top <= bottom) {//If top already crossed with bottom, then we dont need to move from right to left or it will duplicate.
				//Move from right to left
				for(int col = right; col >= left; col--) 
					matrix[bottom][col] = val++;
				bottom--;
			}
			
			if(left <= right) {//If right already crossed with left, then we dont need to move from bottom to top
				//Move from bottom to top
				for(int row = bottom; row >= top; row--)
					matrix[row][left] = val++;
				left++;
			}
		}
		
		return matrix;
	}