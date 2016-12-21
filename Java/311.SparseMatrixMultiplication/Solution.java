public class Solution {

	// Regular solution
    // public int[][] multiply(int[][] A, int[][] B) {
    // 	int common = A[0].length; // colA == rowB
    // 	int rowA = A.length, colB = B[0].length;
    // 	int[][] result = new int[rowA][colB];
    // 	// O(n^3)
    // 	for (int i = 0; i < rowA; i++) {
    // 		for (int j = 0; j < colB; j++) {
    // 			int sum = 0;
    // 			// ith row of A multiply jth col of B
    // 			for (int k = 0; k < common; k++) {
    // 				sum += A[i][k] * B[k][j];
    // 			}
    // 			result[i][j] = sum;
    // 		}
    // 	}

    // 	return result;
    // }

    // Enhanced passed, but still a bit slow.
    // 
	public int[][] multiply(int[][] A, int[][] B) {
		int common = A[0].length; // colA == rowB
    	int rowA = A.length, colB = B[0].length;
    	int[][] result = new int[rowA][colB];

    	boolean[] allZerosA = new boolean[rowA];
    	boolean[] allZerosB = new boolean[colB];
    	Arrays.fill(allZerosA, true);
    	Arrays.fill(allZerosA, true);
    	// O(rowA + colA)
		for (int i = 0; i < rowA; i++) {
			for (int j = 0; j < common; j++) {
				if (A[i][j] != 0) allZerosA[i] = false;
			}
		}

		for (int i = 0; i < colB; i++) {
			for (int j = 0; j < common; j++) {
				if (B[j][i] != 0) allZerosB[i] = false;
			}
		}

		for (int i = 0; i < rowA; i++) {
			for (int j = 0; j < colB; j++) {

				if (allZerosA[i] || allZerosB[j]) {
					result[i][j] = 0;	
				} else {
					int sum = 0;
	    			// ith row of A multiply jth col of B
	    			for (int k = 0; k < common; k++) {
	    				sum += A[i][k] * B[k][j];
	    			}
	    			result[i][j] = sum;
				}
			}
		}
	}
}