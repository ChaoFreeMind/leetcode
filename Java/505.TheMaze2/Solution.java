public class Solution {
    
    private static final int[][] DIRECTIONS = {
        {-1, 0}, // Up
        {1, 0}, // Down
        {0, -1}, // Left 
        {0, 1} // Right
    };
    private int minDist = Integer.MAX_VALUE;

    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        dfs(maze, start, destination, 0);
        return minDist == Integer.MAX_VALUE ? -1 : minDist;
    }

    private void dfs(int[][] maze, int[] start, int[] destination, int curDist) {
        int row = maze.length, col = maze[0].length;
        if (hasArrived(start, destination)) {
            minDist = Math.min(minDist, curDist);
            return;
        }
        // go four directions
        for (int[] dir: DIRECTIONS) {
            int i = start[0], j = start[1];
            int dist = 0;
            
            while (i - 1 >= 0 && i - 1 < row 
                && j - 1 >= 0 && j - 1 < col 
                && maze[i+dir[0]][j+dir[1]] != 1) {
                dist++;
                i += dir[0];
                j += dir[1];
            }

            dfs(maze, new int[]{i, j}, destination, curDist + dist);
        }
    }

    private boolean hasArrived(int[] point, int[] destination) {
        return (point[0] == destination[0]) && (point[1] == destination[1]);
    }

}