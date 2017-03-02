// Given an array of numbers nums, in which exactly two elements appear only 
// once and all the other elements appear exactly twice. Find the two elements 
// that appear only once.

// For example:

// Given nums = [1, 2, 1, 3, 2, 5], return [3, 5].

// Note:
// The order of the result is not important. So in the above example, [5, 3] is 
// also correct.
// Your algorithm should run in linear runtime complexity. Could you implement 
// it using only constant space complexity?

public class Solution {
    // A year later, I still can't solve this problem without checking the 
    // discussion..Got I freaking suck...
    public int[] singleNumber(int[] nums) {
        int xor = 0;
        
        for (int i = 0; i < nums.length; i++) {
            xor ^= nums[i];
        }
        
        // Get the last diff bit
        int diff = xor & (-xor);
        int xorA = 0, xorB = 0;
        
        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] & diff) == 0) {
                xorA ^= nums[i];
            } else {
                xorB ^= nums[i];
            }
        }

        return new int[]{xorA, xorB};
    }
}