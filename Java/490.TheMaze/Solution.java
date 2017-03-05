// Problem: https://leetcode.com/problems/the-maze/?tab=Description
public class Solution {

    private static final int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    // DFS need to keep track of visited nodes(-1) to break infinite loops.
    // public boolean hasPath(int[][] maze, int[] start, int[] destination) {
    //     // If we are alread at the destination, return true
    //     if (start[0] == destination[0] && start[1] == destination[1]) {
    //         return true;
    //     }

    //     // Already been visited
    //     if (maze[start[0]][start[1]] == -1) {
    //         return false;
    //     }

    //     // Visit current start
    //     maze[start[0]][start[1]] = -1;

    //     for (int[] dir: DIRECTIONS) {
    //         int i = start[0], j = start[1];
    //         // Keep rolling until hit the boundary
    //         while (checkBoundary(maze, i + dir[0], j + dir[1])) {
    //             i = i + dir[0];
    //             j = j + dir[1];
    //         }

    //         boolean hasPath = hasPath(maze, new int[]{i, j}, destination);
    //         if (hasPath) return true;
    //     }

    //     // Restore the maze if necessary
    //     return false;
    // }


    class Cell {
        int i;
        int j;
        Cell(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    // BFS, need to define new class Cell
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        Deque<Cell> queue = new ArrayDeque<>();
        queue.offer(new Cell(start[0], start[1]));
        while (!queue.isEmpty()) {
            Cell cur = queue.poll();
            // Visit the current cell
            maze[cur.i][cur.j] = -1;

            for (int[] dir: DIRECTIONS) {
                int i = cur.i, j = cur.j;    
                // Go four directions
                while (checkBoundary(maze, i + dir[0], j + dir[1])) {
                    i += dir[0];
                    j += dir[1];
                }
                // Check if reached the destination
                if (destination[0] == i && destination[1] == j) return true;
                
                if (maze[i][j] != -1) {
                    queue.offer(new Cell(i, j));
                }
            }
        }
        return false;
    }

    // Check if cell (i, j) is valid
    private boolean checkBoundary(int[][] maze, int i, int j) {
        int row = maze.length, col = maze[0].length;
        return i >= 0 && j >= 0 && i < row && j < col && maze[i][j] != 1;
    }

}