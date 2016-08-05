public class Solution {

	//Space: O(max(m, n)) aka max depth of the search tree
	//Time: O(m * n)

	public int numIslands(char[][] grid) {
		//Invalid grid
    	if(grid == null || grid.length == 0 || grid[0].length == 0) {
    		return 0;
    	}
    	int row = grid.length, col = grid[0].length;
    	int island = 0;
    	for(int i = 0; i < row; i++) {
    		for(int j = 0; j < col; j++) {
    			if(grid[i][j] == '1') {
    				dfs(grid, i, j);
    				island++;
    			}
    		}
    	}

    	return island;
	}

	private void dfs(char[][] grid, int i, int j) {
		if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0') return;
		grid[i][j] = 'M';
		dfs(grid, i-1, j);
		dfs(grid, i+1, j);
		dfs(grid, i, j-1);
		dfs(grid, i, j+1);
	}
}