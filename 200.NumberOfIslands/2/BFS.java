public class Solution {
	class Point {
		int i; 
		int j;
		Point(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}
	//Sinking island
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
    				bfs(grid, i, j);
    				island++;
    			}
    		}
    	}

    	return island;
    }
    //Mark before putting them into queue or there will be duplicates!!!
    private void bfs(char[][] grid, int i, int j) {

    	Deque<Point> queue = new LinkedList<>();
    	grid[i][j] = '0';
    	queue.add(new Point(i, j));
    	while(!queue.isEmpty()) {
    		Point p = queue.poll();
    		//For all its neighbors add those whose value are '1'
    		if(p.i - 1 >= 0 && grid[p.i-1][p.j] == '1') {
    		    grid[p.i-1][p.j] = '0';
    			queue.offer(new Point(p.i-1, p.j));
    		}

    		if(p.i + 1 < grid.length && grid[p.i+1][p.j] == '1') {
    		    grid[p.i+1][p.j] = '0';
    			queue.offer(new Point(p.i+1, p.j));
    		}

    		if(p.j - 1 >= 0 && grid[p.i][p.j-1] == '1') {
    		    grid[p.i][p.j-1] = '0';
    			queue.offer(new Point(p.i, p.j-1));
    		}

    		if(p.j + 1 < grid[0].length && grid[p.i][p.j+1] == '1') {
    		    grid[p.i][p.j+1] = '0';
    			queue.offer(new Point(p.i, p.j+1));
    		}

    	}
    }

}