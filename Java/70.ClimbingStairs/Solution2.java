// You are climbing a stair case. It takes n steps to reach to the top.

// Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

// Note: Given n will be a positive integer.

// This is a typical dp problem, we can solve it by bottom-up and top-down approach.


public class Solution {

    // Regular top-down approach, there are many duplicate subproblems, TLE when n = 44
    public int climbStairs(int n) {
        // return topDown(n);
        // return topDownMemo(n, new int[n + 1]);
        // return bottomUp(n, new int[n + 1]);
        return bottomUpConstSpace(n);
    }

    // O(2^n) time, O(n) stack space
    private int topDown(int n) {
        if (n == 0) return 1;
        else if (n < 0) return 0;
        return topDown(n - 1) + topDown(n - 2);
    }
    
    // O(n) time, O(2*n) space: memo + stack
    private int topDownMemo(int n, int[] memo) {
        if (n == 0) return 1;
        else if (n < 0) return 0;
        if (memo[n] == 0) {
            memo[n] = topDownMemo(n - 2, memo) + topDownMemo(n - 1, memo);
        }
        return memo[n];
    }

    // O(n) time, O(n) space
    private int bottomUp(int n, int[] dp) {
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
    // O(n) time, O(1) space
    private int bottomUpConstSpace(int n) {
        int a = 1, b = 1;
        for (int i = 2; i <= n; i++) {
            int temp = a + b;
            a = b;
            b = temp;
        }
        return b;
    }
}