// https://leetcode.com/problems/island-perimeter/?tab=Description
// You are given a map in form of a two-dimensional integer grid where 1 represents land and 0 
// represents water. Grid cells are connected horizontally/vertically (not diagonally). The grid is 
// completely surrounded by water, and there is exactly one island (i.e., one or more connected land
//  cells). The island doesn't have "lakes" (water inside that isn't connected to the water around 
// the island). One cell is a square with side length 1. The grid is rectangular, width and height 
// don't exceed 100. Determine the perimeter of the island.

// Example:

// [[0,1,0,0],
//  [1,1,1,0],
//  [0,1,0,0],
//  [1,1,0,0]]

// Answer: 16
// Explanation: The perimeter is the 16 yellow stripes in the image below:
// [Picture]

// For each land cell, it will contribute [number of adjacenet water cells] units of length to the 
// total perimeter.
public class Solution {
    public int islandPerimeter(int[][] grid) {
        int res = 0;
        int row = grid.length, col = grid[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    res += getPerimeter(grid, i, j);
                }
            }
        }
        return res;
    }

    private int getPerimeter(int[][] grid, int i, int j) {
        int res = 0;
        int row = grid.length, col = grid[0].length;
        int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for (int[] d: dir) {
            int x = i + d[0], y = j + d[1];
            if (isValid(grid, x, y) && grid[x][y] == 1) continue;
            res++;
        }
        return res;
    }

    // Return if the current point in grid is valid
    private boolean isValid(int[][] grid, int i, int j) {
        return i >= 0 && i < grid.length && j >= 0 && j < grid[0].length;
    }
}
