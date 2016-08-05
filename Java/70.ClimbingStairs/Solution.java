public class Solution {
    //Standard DP. Come on, we are starting at stair zero!
    /*public int climbStairs(int n) {
        if(n <= 0) return -1;
        int[] dp = new int[n+1];//Denotes the number of ways to jump to the current stair
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i <= n; i++)
            dp[i] = dp[i-2] + dp[i-1];
        return dp[n];
    }*/
    
    public int climbStairs(int n) {
        if(n <= 0) return -1;
        if(n == 1) return 1;
        int one = 1, two = 1;
        for(int i = 2; i < n; i++) {
            int temp = one;
            one = one + two;
            two = temp;
        }
            
        return one + two;
    }
    
}