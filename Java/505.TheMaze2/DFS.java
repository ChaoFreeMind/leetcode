// Problem: https://leetcode.com/problems/the-maze-ii/?tab=Description
// This problem is tough!!


public class Solution {

    private static final int[][] DIRECTIONS = {
        {-1, 0}, // Up
        {1, 0}, // Down
        {0, -1}, // Left 
        {0, 1} // Right
    };

    public int shortestDistance(int[][] maze, int[] start, int[] destination) {

        // dist[i][j] denotes the min distance so far from our original 
        // starting point to current node (i, j)
        int[][] dist = new int[maze.length][maze[0].length];
        // This is important because we need to make sure we do not visit 
        // starting point twice.
        dist[start[0]][start[1]] = 1;
        dfs(maze, start, destination, dist);
        return dist[destination[0]][destination[1]] - 1;
    }

    // This dfs will get TLE
    private void dfs(int[][] maze, int[] start, int[] dest, int[][] dist) {

        if (start[0] == dest[0] && start[1] == dest[1]) return;

        // go four directions
        for (int[] dir: DIRECTIONS) {
            int i = start[0], j = start[1];
            int distMoved = 0;

            while (boundaryCheck(maze, i + dir[0], j + dir[1])) {
                i += dir[0];
                j += dir[1];
                distMoved++;
            }

            if (distMoved == 0) continue;

            int newDist = dist[start[0]][start[1]] + distMoved;

            if (dist[i][j] == 0 || newDist < dist[i][j]) {
                dist[i][j] = newDist;
                dfs(maze, new int[]{i, j}, dest, dist);
            }

        }
    }


    // See if i, j is valid
    private boolean boundaryCheck (int[][] maze, int i, int j) {
        return i >= 0 && i < maze.length && j >= 0 && j < maze[0].length && maze[i][j] != 1;
    }

}