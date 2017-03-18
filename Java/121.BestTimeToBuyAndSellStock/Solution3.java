// Say you have an array for which the ith element is the price of a given stock on day i.

// If you were only permitted to complete at most one transaction (ie, buy one and sell one share of
// the stock), design an algorithm to find the maximum profit.

// Example 1:
// Input: [7, 1, 5, 3, 6, 4]
// Output: 5

// max. difference = 6-1 = 5 (not 7-1 = 6, as selling price needs to be larger than buying price)
// Example 2:
// Input: [7, 6, 4, 3, 1]
// Output: 0

// In this case, no transaction is done, i.e. max profit = 0.
public class Solution {
    // Naive approach: O(n^2) time, O(1) space. TLE
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            // Assume we buy at i, sell at j, collect the max profit.
            for (int j = i + 1; j < prices.length; j++) {
                maxProfit = Math.max(maxProfit, prices[j] - prices[i]);
            }
        }

        return maxProfit;
    }


    // O(n) time, O(1) space.
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        // The minimum price until but not including current price.
        int minSoFar = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            maxProfit = Math.max(maxProfit, prices[i] - minSoFar);
            minSoFar = Math.min(minSoFar, prices[i]);
        }

        return maxProfit;
    }
}