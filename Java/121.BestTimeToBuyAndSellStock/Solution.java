public class Solution {
    //Straight forward solution.
	public int maxProfit(int[] prices) {
		int minPrice = prices[0];//Keep track of the minimum price so far
		int maxProfit = 0;//Keep track of the maxprofit if sell at price i
		
		for(int i = 1; i < prices.length; i++) {
			int curProfit = prices[i] - minPrice;
			maxProfit = Math.max(curProfit, maxProfit);
			minPrice = Math.min(minPrice, prices[i]);
		}
		
		return maxProfit;
    }
	
}