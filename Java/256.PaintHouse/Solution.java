// There are a row of n houses, each house can be painted with one of the three colors: red, blue or
// green. The cost of painting each house with a certain color is different. You have to paint all 
// the houses such that no two adjacent houses have the same color.

// The cost of painting each house with a certain color is represented by a n x 3 cost matrix. For 
// example, costs[0][0] is the cost of painting house 0 with color red; costs[1][2] is the cost of 
// painting house 1 with color green, and so on... Find the minimum cost to paint all houses.

// Note:
// All costs are positive integers.
public class Solution {

    // First attempt: O(n) time, where n is the number of houses. O(1) space.
    public int minCost(int[][] costs) {
        // The minimum cost so far if we 
        int red = 0, blue = 0, green = 0;

        for (int i = 0; i < costs.length; i++) {

            int curRed = Math.min(blue, green) + costs[i][0];
            int curBlue = Math.min(red, green) + costs[i][1];
            int curGreen = Math.min(red, blue) + costs[i][2];
            red = curRed;
            blue = curBlue;
            green = curGreen;

        }

        return min(red, blue, green);
    }

    private int min(int a, int b, int c) {
        return Math.min(Math.min(a, b), c);
    }
}