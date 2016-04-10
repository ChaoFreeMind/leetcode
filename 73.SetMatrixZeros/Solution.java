public void setZeroes(int[][] matrix) {
    	int m = matrix.length, n = matrix[0].length;
    	//Use first row and first column as marks, if there is a zero in the original
    	//matrix mark its row and column as zero, then we just need to check the first row and col to set zeros
    	boolean clearFirstRow = false, clearFirstCol = false;
    	for(int i = 0; i < m; i++) {
    		for(int j = 0; j < n; j++) {
    			if(matrix[i][j] == 0) {
    				matrix[i][0] = 0;
    				matrix[0][j] = 0;
    				if(i == 0) clearFirstRow = true;
    				if(j == 0) clearFirstCol = true;
    			}
    		}
    	}
    	
    	for(int i = 1; i < m; i++) {
    		for(int j = 1; j < n; j++) {
    			if(matrix[i][0] == 0 || matrix[0][j] == 0) {
    				matrix[i][j] = 0;
    			}
    		}
    	}
    	
    	if(clearFirstRow) {
    		for(int j = 0; j < n; j++)
    			matrix[0][j] = 0;
    	}
    	if(clearFirstCol) {
    		for(int i = 0; i < m; i++) {
    			matrix[i][0] = 0;
    		}
    	}
    }