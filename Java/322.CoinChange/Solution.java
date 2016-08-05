public class Solution {
    public int coinChange(int[] coins, int amount) {
    	if(amount < 0) return -1;
        int[] dp = new int[amount+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i = 1; i <= amount; i++) {
        	for(int j = 0; j < coins.length; j++) {
        		if(i >= coins[j] && dp[i-coins[j]] != Integer.MAX_VALUE) {
        			dp[i] = Math.min(dp[i - coins[j]] + 1, dp[i]);
        		}
        	}
        }
        return dp[amount];
    }
}