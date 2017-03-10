// https://leetcode.com/problems/walls-and-gates/?tab=Description

// You are given a m x n 2D grid initialized with these three possible values.

// -1 - A wall or an obstacle.
// 0 - A gate.
// INF - Infinity means an empty room. We use the value 231 - 1 = 2147483647 to represent INF as you
//  may assume that the distance to a gate is less than 2147483647.
// Fill each empty room with the distance to its nearest gate. If it is impossible to reach a gate, 
// it should be filled with INF.

// For example, given the 2D grid:
// INF  -1  0  INF
// INF INF INF  -1
// INF  -1 INF  -1
//   0  -1 INF INF
// After running your function, the 2D grid should be:
//   3  -1   0   1
//   2   2   1  -1
//   1  -1   2  -1
//   0  -1   3   4



// Multipoint BFS.
public class Solution {

    private int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public void wallsAndGates(int[][] rooms) {
        if (rooms == null || rooms.length == 0 || rooms[0].length == 0) return;
        final int ROW = rooms.length, COL = rooms[0].length;
        Deque<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                if (rooms[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int dist = rooms[cur[0]][cur[1]];
            // Pull out the adjacent cells and do updates.
            for (int[] dir: dirs) {
                int adjRow = cur[0] + dir[0];
                int adjCol = cur[1] + dir[1];
                if (isValid(adjRow) && rooms[adjRow][adjCol] == Integer.MAX_VALUE) {
                    // Update the distance
                    rooms[adjRow][adjCol] = dist + 1;
                    queue.offer(new int[]{adjRow, adjCol});
                }
            }
        }
    }

    // Check if the provided coordinate is valid
    private boolean isValid(int[][] rooms, int i, int j) {
        return i >= 0 && i < rooms.length && j >= 0 && j < rooms[0].length;
    }

}