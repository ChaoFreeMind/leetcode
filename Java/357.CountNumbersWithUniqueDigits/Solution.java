// Backtracking
// Given a non-negative integer n, count all numbers with unique digits, x, where 0 ≤ x < 10n.

// Example:
// Given n = 2, return 91. (The answer should be the total numbers in the range of 0 ≤ x < 100, excluding [11,22,33,44,55,66,77,88,99])

public class Solution {

	private long max = 0;
    private int count = 1;
    public int countNumbersWithUniqueDigits(int n) {
    	boolean[] used = new boolean[10];//appear[i] means if i has been used in previous digit.
    	max = (long) Math.pow(10, n);

    	for(int i = 1; i <= 9; i++) {
    		used[i] = true;
    		backtrack(i, used);
    		used[i] = false;
    	}

    	return count;
    }


    private void backtrack(long prev, boolean[] used) {

    	if(prev >= max) return;
        
        count++;//Add count for prev number.
        
    	for(int i = 0; i < 10; i++) {
    		//if i has not been used previously, try to use it to generate a new number.
    		if(!used[i]) {
    			long newPrev = prev * 10 + i;
    			used[i] = true;
    			backtrack(newPrev, used);
    			used[i] = false;
    		}
    	}

    }

}