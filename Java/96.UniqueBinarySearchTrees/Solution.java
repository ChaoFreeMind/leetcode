public class Solution {
	
	public static void main(String[] args) {
		new Solution().numTrees(3);
	}
	
    public int numTrees(int n) {
    	int[] dp = new int[n+1]; //dp[i] denotes that the number of unique binary trees can be built taking i as the root
    	dp[0] = 1;
    	dp[1] = 1;
    	for(int i = 2; i <= n; i++) {
    		for(int j = 1; j <= i; j++) {
    			//iteratively choose 1 to i as root, the sum would be the number of bsts.
    			dp[i] += dp[j-1] * dp[i-j];
    		}
    	}
    	
    	return dp[n];
    }
    
}