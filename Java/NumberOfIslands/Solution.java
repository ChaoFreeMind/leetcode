//Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
//
//Example 1:
//
//11110
//11010
//11000
//00000
//Answer: 1
//
//Example 2:
//
//11000
//11000
//00100
//00011
//Answer: 3
public class Solution {
    	private int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

	// DFS mark island along the way, the number of island is the number of dfs
	// executed
	public int numIslands(char[][] grid) {

		if (grid == null || grid.length == 0) {
			return 0;
		}
		int row = grid.length;
		int col = grid[0].length;

		int island = 0;

		for (int i = 0; i < row; i++) {

			for (int j = 0; j < col; j++) {

				if (grid[i][j] == '1') {
					dfs(grid, i, j);
					island++;
				}

			}

		}

		return island;

	}

	private void dfs(char[][] grid, int m, int n) {

		// Mark visited
		grid[m][n] = 'x';
		for (int i = 0; i < dir.length; i++) {
			int x = m + dir[i][0];
			int y = n + dir[i][1];

			if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length
					&& grid[x][y] == '1') {
				dfs(grid, x, y);
			}

		}

	}
}