// Given a binary array, find the maximum number of consecutive 1s in this array if you can flip at 
// most one 0.

// Example 1:
// Input: [1,0,1,1,0]
// Output: 4
// Explanation: Flip the first zero will get the the maximum number of consecutive 1s.
//     After flipping, the maximum number of consecutive 1s is 4.
// Note:

// The input array will only contain 0 and 1.
// The length of input array is a positive integer and will not exceed 10,000
// Follow up:
// What if the input numbers come in one by one as an infinite stream? In other words, you can't 
// store all numbers coming from the stream as it's too large to hold in memory. Could you solve it 
// efficiently?

public class Solution {

    // Populate two dp arrays: start and end.
    // When we see a 0, the number of consecutive 1s when we flip it is equal to end[i-1] + start[i+1]
    public int findMaxConsecutiveOnes(int[] nums) {
        // end[i]: Number of 1s ending at index i
        int[] end = new int[nums.length];
        int[] start = new int[nums.length];
        int ones = 0;
        int maxOriginal = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                ones++;
                maxOriginal = Math.max(maxOriginal, ones);
                end[i] = ones;
            } else {
                ones = 0;
            }
        }

        ones = 0;
        // start[i]: Number of 1s starting from i
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] == 1) {
                ones++;
                start[i] = ones;
            } else {
                ones = 0;
            }
        }

        int max = 0;
        // In case of all 1s, return the number of 1s.
        if (maxOriginal == nums.length) return maxOriginal;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                // If we flip the current 0...
                int localMax = 1;
                if (i - 1 >= 0) {
                    localMax += end[i - 1];
                }

                if (i + 1 < nums.length) {
                    localMax += start[i + 1];
                }
                max = Math.max(localMax, max);
            }
        }

        return max;
    }
}