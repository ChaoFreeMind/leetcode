// Given an array of integers, every element appears three times except for one, which appears 
// exactly once. Find that single one.

// Note:
// Your algorithm should have a linear runtime complexity. Could you implement it without using 
// extra memory?
public class Solution {
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            // For ith bit, the sum of 1 bit on.
            int sumOfOneBit = 0;
            int mask = 1 << i;
            for (int num: nums) {
                if ((num & mask) == mask) {
                    sumOfOneBit++;
                }
            }
            res |= ((sumOfOneBit % 3) << i);
        }
        return res;
    }
}