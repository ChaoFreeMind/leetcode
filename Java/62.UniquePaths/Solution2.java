// A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

// The robot can only move either down or right at any point in time. The robot is trying to reach 
// the bottom-right corner of the grid (marked 'Finish' in the diagram below).

// How many possible unique paths are there?
public class Solution {
    public int uniquePaths(int m, int n) {
        // Top down
        // int[][] memo = new int[m][n];
        // memo[0][0] = 1;
        // return topDownMemo(m - 1, n - 1, memo);

        // Bottom-up, from (0, 0) to (m - 1, n - 1)
        // return bottomUp(m, n);

        // Bottom-up with Space of O(n) or O(m)
        return bottomUpImproved(m, n);
    }
    // O(n * m) time and space
    private int topDownMemo(int i, int j, int[][] memo) {
        if (i < 0 || j < 0 || i >= memo.length || j >= memo[0].length) return 0;
        if (memo[i][j] == 0) {
            // We will only be reached from up or left cell
            memo[i][j] = topDownMemo(i - 1, j, memo) + topDownMemo(i, j - 1, memo);
        }
        return memo[i][j];
    }

    // O(n * m) time and space
    private int bottomUp(int m, int n) {
        int[][] dp = new int[m][n];
        
        for (int i = 0; i < m; i++) dp[i][0] = 1;
        for (int j = 0; j < n; j++) dp[0][j] = 1;

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                // Current cell can only be reached from top or left
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }

        return dp[m-1][n-1];
    }

    // O(n * m) time and O(n) space
    private int bottomUpImproved(int m, int n) {
        // Only keep track of last row
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int res = 1;
        for (int i = 1; i < m; i++) {
            int left = 1;
            for (int j = 1; j < n; j++) {
                res = dp[j] + left;
                dp[j] = res;
                left = res;
            }
        }
        return res;
    }
}