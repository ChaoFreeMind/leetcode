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



// No need to maintain a visited matrix because we can do it only if current distance is less than
// current value of the room: -1 and 0 will be skipped because dist would always be greater than 0.
public class Solution {

    private int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public void wallsAndGates(int[][] rooms) {
        if (rooms == null || rooms.length == 0 || rooms[0].length == 0) return;
        final int ROW = rooms.length, COL = rooms[0].length;

        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                if (rooms[i][j] == 0) {
                    for (int[] dir: dirs) {
                        dfs(rooms, i + dir[0], j + dir[1], 1);
                    }
                }
            }
        }
    }

    private void dfs(int[][] rooms, int i, int j, int dist) {

        if (!isValid(rooms, i, j) || dist >= rooms[i][j]) {
            return;
        }

        rooms[i][j] = dist;

        for (int[] dir: dirs) {
            dfs(rooms, i + dir[0], j + dir[1], dist + 1);
        }

    }

    // Check if the provided coordinate is valid
    private boolean isValid(int[][] rooms, int i, int j) {
        return i >= 0 && i < rooms.length && j >= 0 && j < rooms[0].length;
    }

}