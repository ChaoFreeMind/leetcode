public class Solution {
	//Easier tho trickier way.
	//By observation, our factor should have as many 3s as possible.
	//For example 6, if we split it by 3 + 3 we have 9, if we split it by 2 + 2 + 2 we have 8
    /*public int integerBreak(int n) {
    	if(n == 2 || n == 3) return n-1;
    	int product = 1;
    	while(n > 4) {
    		product *= 3;
    		n -= 3;
    	}

    	return product;
    }*/

    //A CS way: dp!!
    public int integerBreak(int n) {
    	// if(n == 2 || n == 3) return n - 1;
    	int[] dp = new int[n+1];
    	dp[1] = 1;
    	for(int i = 2; i <= n; i++) {
    		for(int j = 1; j <= i / 2; j++) {
    			// dp[i] = Math.max(dp[j] * dp[i - j], dp[i]);
    			//Decide if we split or not: for 2 3, the product is bigger than factor them.
    			dp[i] = Math.max(Math.max(dp[j], j) * Math.max(dp[i-j], i-j), dp[i]);
    		}

    	}

    	return dp[n];
    }
}	