// Assume you have an array of length n initialized with all 0's and are given k update operations.

// Each operation is represented as a triplet: [startIndex, endIndex, inc] which increments each 
// element of subarray A[startIndex ... endIndex] (startIndex and endIndex inclusive) with inc.

// Return the modified array after all k operations were executed.

// Example:

// Given:

//     length = 5,
//     updates = [
//         [1,  3,  2],
//         [2,  4,  3],
//         [0,  2, -2]
//     ]

// Output:

//     [-2, 0, 3, 5, 3]
// Explanation:

// Initial state:
// [ 0, 0, 0, 0, 0 ]

// After applying operation [1, 3, 2]:
// [ 0, 2, 2, 2, 0 ]

// After applying operation [2, 4, 3]:
// [ 0, 2, 5, 5, 3 ]

// After applying operation [0, 2, -2]:
// [-2, 0, 3, 5, 3 ]
public class Solution {
    // Straight forward: go through all updates, do each one of the update,
    // return the final array
    // Time: O(m * n * n) where m is the number of updates and n is the length
    // TLE!!
    // public int[] getModifiedArray(int length, int[][] updates) {
    //     int[] res = new int[length];

    //     for (int[] u: updates) {
    //      int start = u[0], end = u[1], delta = u[2];
    //      for (int i = start; i <= end; i++) {
    //          res[i] += delta;
    //      }
    //     }

    //     return res;
    // }

    // For each update, set start index to inc and position end + 1 to -inc.
    // Sum up in the end
    public int[] getModifiedArray(int length, int[][] updates) {
        if (length <= 0) return new int[0];
        int[] temp = new int[length];

        for (int[] update: updates) {
            int start = update[0];
            int end = update[1];
            int inc = update[2];
            temp[start] += inc;
            if (end < length - 1) temp[end + 1] -= inc;
        }
        
        int[] sum = new int[length];

        sum[0] = temp[0];

        for (int i = 1; i < length; i++) {
            sum[i] = sum[i - 1] + temp[i];
        }

        return sum;
    }
}