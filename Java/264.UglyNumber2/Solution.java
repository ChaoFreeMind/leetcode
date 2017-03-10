// Write a program to find the n-th ugly number.

// Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. For example, 1, 2, 3,
// 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.

// Note that 1 is typically treated as an ugly number, and n does not exceed 1690.
public class Solution {

    public int nthUglyNumber(int n) {
        // Factors to generate new ugly number
        int two = 1, three = 1, five = 1;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = tripleMin(dp[two] * 2, dp[three] * 3, dp[five] * 5);
            if (dp[i] == dp[two] * 2) two++;
            if (dp[i] == dp[three] * 3) three++;
            if (dp[i] == dp[five] * 5) five++;
        }
        // for (int num: dp) {
        //  System.out.println(num);
        // }
        return dp[n];
    }

    // Return the minimum number among 3 given numbers
    private int tripleMin(int a, int b, int c) {
        return Math.min(Math.min(a, b), c);
    }
    
    // public static void main(String[] args) {
    //  new Solution().nthUglyNumber(13);
    // }

}