public void rotate(int[][] matrix) {
	int n = matrix.length;
	//First, mirror by diagonal from upper left to lower right.(Just switch i and j)
	//Do not try to do it anti-diagonal wise, hard to think!
	for(int i = 0; i < n; i++) {//Row
		for(int j = i; j < n; i++) {//Col
			int temp = matrix[i][j];
			matrix[i][j] = matrix[j][i];
			matrix[j][i] = temp;
		}
	}
	
	//Second, flip the image by y-axis.
	for(int i = 0; i < n; i++) {//Row
		for(int j = 0; j < n / 2; j++) {//Col
			int temp = matrix[i][j];
			matrix[i][j] = matrix[i][n - j - 1];
			matrix[i][n-j-1] = temp;
		}
		
	}
}