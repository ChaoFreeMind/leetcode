// Problem: https://leetcode.com/problems/the-maze-ii/?tab=Description
// This problem is tough!!

public class Solution {

    class Cell {
        int x;
        int y;
        // int dist;
        Cell (int x, int y) {
            this.x = x;
            this.y = y;
            // this.dist = dist;
        }
    }

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
        // Initialize dist array with distance of Integer.MAX_VALUE
        initDist(dist);
        dist[start[0]][start[1]] = 0;
        bfs(maze, start, destination, dist);
        // Alias to make the return statement shorter
        int distFinal = dist[destination[0]][destination[1]];
        return distFinal == Integer.MAX_VALUE ? -1 : distFinal;
    }

    private void bfs(int[][] maze, int[] start, int[] dest, int[][] dist) {
        Deque<Cell> queue = new ArrayDeque<>();
        queue.offer(new Cell(start[0], start[1]));
        while (!queue.isEmpty()) {
            // Current visiting cell
            Cell cell = queue.poll();
            // go four directions
            for (int[] dir: DIRECTIONS) {
                int i = cell.x, j = cell.y;
                int distMoved = 0;

                while (boundaryCheck(maze, i + dir[0], j + dir[1])) {
                    i += dir[0];
                    j += dir[1];
                    distMoved++;
                }
                int newDist = dist[cell.x][cell.y] + distMoved;

                if (newDist >= dist[i][j]) continue;

                dist[i][j] = newDist;
                queue.offer(new Cell(i, j));
            }
        }
        
    }


    // See if i, j is valid
    private boolean boundaryCheck (int[][] maze, int i, int j) {
        return i >= 0 && i < maze.length && j >= 0 && j < maze[0].length && maze[i][j] != 1;
    }

    private void initDist(int[][] dist) {
        for (int[] row: dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
    }

}