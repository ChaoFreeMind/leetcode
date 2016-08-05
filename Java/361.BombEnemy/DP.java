//Just compute enemies between walls once and store them.
public class Solution {
	public int maxKilledEnemies(char[][] grid) {
	    if(grid == null || grid.length == 0 || grid[0].length == 0) return 0;
		int row = grid.length, col = grid[0].length;
		int[] colCounts = new int[col];
		int rowCount = 0;
		int maxCount = 0;
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < col; j++) {
				if(j == 0 || grid[i][j-1] == 'W') {
					rowCount = 0;
					//Starting from j, scan for enemies to its right
					for(int k = j; k < col && grid[i][k] != 'W'; k++) {
					    if(grid[i][k] == 'E') rowCount++;
					}
				}

				if(i == 0 || grid[i-1][j] == 'W') {
					colCounts[j] = 0;
					for(int k = i; k < row && grid[k][j] != 'W'; k++) {
					    if(grid[k][j] == 'E') colCounts[j]++;
					}
				}

				if(grid[i][j] == '0') {
					maxCount = Math.max(rowCount + colCounts[j], maxCount);
				} 

			}

		}
		
		return maxCount;
	}
}