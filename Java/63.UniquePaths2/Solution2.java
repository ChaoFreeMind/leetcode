// Follow up for "Unique Paths":

// Now consider if some obstacles are added to the grids. How many unique paths would there be?

// An obstacle and empty space is marked as 1 and 0 respectively in the grid.

// For example,
// There is one obstacle in the middle of a 3x3 grid as illustrated below.

// [
//   [0,0,0],
//   [0,1,0],
//   [0,0,0]
// ]
// The total number of unique paths is 2.

// Note: m and n will be at most 100.

public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0) {
            return 0;
        }
        int ROW = obstacleGrid.length, COL = obstacleGrid[0].length;
        int[][] dp = new int[ROW][COL];
        for (int i = 0; i < ROW; i++) {
            if (obstacleGrid[i][0] == 1) break;
            else dp[i][0] = 1;
        }
        for (int j = 0; j < COL; j++) {
            if (obstacleGrid[0][j] == 1) break;
            else dp[0][j] = 1;
        }

        for (int i = 1; i < ROW; i++) {
            for (int j = 1; j < COL; j++) {
                if (obstacleGrid[i][j] != 1) {
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }

        return dp[ROW-1][COL-1];
    }

    // Improved space to O(COL)
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0) {
            return 0;
        }
        int ROW = obstacleGrid.length, COL = obstacleGrid[0].length;
        int[] dp = new int[COL];
        dp[0] = 1;

        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[j] = 0;
                } else if (j > 0){
                    dp[j] = dp[j] + dp[j-1];
                }
            }
        }

        return dp[COL-1];
    }
}