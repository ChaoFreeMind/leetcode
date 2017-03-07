// Given a binary array, find the maximum number of consecutive 1s in this array.

// Example 1:
// Input: [1,1,0,1,1,1]
// Output: 3
// Explanation: The first two digits or the last three digits are consecutive 1s.
//     The maximum number of consecutive 1s is 3.
// Note:

// The input array will only contain 0 and 1.
// The length of input array is a positive integer and will not exceed 10,000
public class Solution {
    // Iterate through the array, if we meet a one, then there are two cases: 1. this 'one' is 
    // included in a consecutive sequence of one. 2. This one is the start of a new consecutive 
    // sequence. If we meet a zero, then we need to end the consecutive one sequence, or ignore it 
    // if previous element is also a zero.
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int counter = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                counter++;
                if (i == nums.length - 1) {
                    max = Math.max(max, counter);
                }
            } else {
                max = Math.max(max, counter);
                counter = 0;
            }
        }
        return max;
    }

    // Slightly improved
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int counter = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                counter++;
                max = Math.max(max, counter);
            } else {
                counter = 0;
            }
        }
        return max;
    }
}