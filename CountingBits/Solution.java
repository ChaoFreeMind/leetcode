public int[] countBits(int num) {
		int[] dp = new int[num];
		
		for(int i = 1; i <= num; i++) {
			
			dp[i] = (i % 2 == 0) ? dp[i / 2] : dp[i / 2] + 1;
			
		}
		
		return dp;
    }