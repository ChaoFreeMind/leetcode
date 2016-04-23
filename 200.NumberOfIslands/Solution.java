import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
//	11000
//	11000
//	00100
//	00011
	public static void main(String[] args) {
		char[][] grid = {{'1','1','0','0','0'}, {'1','1','0','0','0'}, {'0','0','1','0','0'},{'0','0','0','1','1'}};
		System.out.println(new Solution().numIslands(grid));
	}
	
	private static class Pair {
		int x;
		int y;
		Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	//Sinking island, go through the grid, every time when we find a piece of land, 
	//We run BFS to sink it. (Mark sinked island as 'M') Count the number of BFS' we run.
	public int numIslands(char[][] grid) {
		if(grid == null || grid.length == 0 || grid[0].length == 0) return 0; 
		int row = grid.length, col = grid[0].length;
		int island = 0;
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < col; j++) {
				if(grid[i][j] == '1') {
					island++;
					//bfs(grid, i, j);
					dfs(grid, i, j);
				}
			}			
		}
		return island;
    }
	
	private void dfs(char[][] grid, int x, int y) {
		if(x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] != '1') return;
		grid[x][y] = 'M';
		dfs(grid, x - 1, y);
		dfs(grid, x + 1, y);
		dfs(grid, x, y - 1);
		dfs(grid, x, y + 1);
	}
	
	private void bfs(char[][] grid, int x, int y) {
		int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
		Deque<Pair> queue = new ArrayDeque<>();
		grid[x][y] = 'M';
		queue.offer(new Pair(x, y));
		while(!queue.isEmpty()) {
			Pair p = queue.poll();
			for(int i = 0; i < dir.length; i++) {
				int m = p.x + dir[i][0];
				int n = p.y + dir[i][1];
				if(m >= 0 && m < grid.length && n >= 0 && n < grid[0].length && grid[m][n] == '1') {
					grid[m][n] = 'M';
					queue.add(new Pair(m, n));
				}
			}
		}
	}
	
}