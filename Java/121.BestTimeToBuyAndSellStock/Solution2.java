public class Solution {
	// TLE O(n^2)
    public int maxProfit(int[] prices) {
    	if (prices.length == 0) return 0;
    	int max = 0;
        for (int i = 0; i < prices.length - 1; i++) {
        	for (int j = i + 1; j < prices.length; j++) {
        		max = Math.max(max, prices[j] - prices[i]);
        	}
        }
        return max;
    }

    public int maxProfit(int[] prices) {
    	if (prices == null || prices.length == 0) return 0;
    	int max = 0, minSoFar = prices[0];

    	for (int i = 1; i < prices.length; i++) {
    		if (prices[i] < minSoFar) minSoFar = prices[i];
    		else max = Math.max(max, prices[i] - minSoFar);
    	}

    	return max;
    }
}