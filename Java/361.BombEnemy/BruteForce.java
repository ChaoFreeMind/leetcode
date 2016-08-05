public class Solution {
	//Brute force
    public int maxKilledEnemies(char[][] grid) {
    	if(grid == null || grid.length == 0 || grid[0].length == 0) return 0;
    	int row = grid.length, col = grid[0].length;
    	int max = 0;
    	for(int i = 0; i < row; i++) {
    		for(int j = 0; j < col; j++) {
    			if(grid[i][j] == '0') {
    				//Compute the number of enemies we can kill if we plant a bomb here.
    				max = Math.max(kill(grid, i, j), max);
    			}
    		}
    	}
    	return max;
    }

    private int kill(char[][] grid, int row, int col) {
    	int count = 0;
    	int j = col - 1;
    	//Left
    	while(j >= 0 && grid[row][j] != 'W') {
    		if(grid[row][j] == 'E') count++;
    		j--;
    	}
    	j = col + 1;
    	//Right
    	while(j < grid[0].length && grid[row][j] != 'W') {
    		if(grid[row][j] == 'E') count++;
    		j++;
    	}

    	int i = row - 1;
    	//Up
    	while(i >= 0 && grid[i][col] != 'W') {
    		if(grid[i][col] == 'E') count++;
    		i--;
    	}

    	//Down
    	i = row + 1;
    	while(i < grid.length && grid[i][col] != 'W') {
    		if(grid[i][col] == 'E') count++;
    		i++;
    	}
    	return count;
    }
}