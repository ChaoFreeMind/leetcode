public class Solution {

    public int numberOfArithmeticSlices(int[] A) {
    	int len = 0; // Length of the current sub-AS
    	int sum = 0;
    	Map<Integer, Integer> lenMap = new HashMap<>();
    	// Find the longest ArithmeticSequence length.
    	for (int i = 1; i < A.length - 1; i++) {
    		if ((A[i] - A[i-1]) == (A[i+1] - A[i])) {
    			len = (len == 0) ? 3 : (len + 1);
    		} else if (len != 0) {
    			// We have found an AS.
    			int subCount = lenMap.getOrDefault(len, countSubSeq(len));
    			lenMap.putIfAbsent(len, subCount);
    			sum += subCount;
    			len = 0;
    		}
    	}
        
        // If ends with AS
        if (len != 0) {
            sum += lenMap.getOrDefault(len, countSubSeq(len));
        }
        
    	return sum;
    }

    // n is the total length of the subsequence
    private int countSubSeq(int n) {
    	int sum = 0;
    	for (int i = 3; i <= n; i++) {
    		sum += (n - i + 1);
    	}
    	return sum;
    }

}