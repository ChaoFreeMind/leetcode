// Say you have an array for which the ith element is the price of a given stock on day i.

// Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times) with the following restrictions:

// You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
// After you sell your stock, you cannot buy stock on next day. (ie, cooldown 1 day)
// Example:

// prices = [1, 2, 3, 0, 2]
// maxProfit = 3
// transactions = [buy, sell, cooldown, buy, sell]

//Let buy[i] denotes the profit on day i that ends with a buy operation.(Buy before day i and rest till day i or buy exactly on day i)
//sell[i] denotes the profit on day i when we sell stock.

//buy[i] = max(sell[i-2]-price, buy[i-1])
//sell[i] = max(sell[i-1], buy[i-1] + price)
public class Solution {
	public int maxProfit(int[] prices) {
		if(prices == null || prices.length == 0) return 0;
		int n = prices.length;
		// int[] buy = new int[n+1];
		// int[] sell = new int[n+1];
		int s1 = 0, s2 = 0, b1 = -prices[0];
		for(int i = 1; i < prices.length; i++) {
			int temp = b1;
			b1 = Math.max(b1, s2 - prices[i]);
			s2 = s1;//Do not forget to update s2
			s1 = Math.max(s1, temp + prices[i]);

		}

		return s1;
	}
}