// The Hamming distance between two integers is the number of positions at which the corresponding 
// bits are different.

// Now your job is to find the total Hamming distance between all pairs of the given numbers.

// Example:
// Input: 4, 14, 2

// Output: 6

// Explanation: In binary representation, the 4 is 0100, 14 is 1110, and 2 is 0010 (just
// showing the four bits relevant in this case). So the answer will be:
// HammingDistance(4, 14) + HammingDistance(4, 2) + HammingDistance(14, 2) = 2 + 2 + 2 = 6.
// Note:
// Elements of the given array are in the range of 0 to 10^9
// Length of the array will not exceed 10^4.
public class Solution {

    // TLE O(n^2)
    public int totalHammingDistance(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int dist = hammingDistance(nums[i], nums[j]);
                res += dist;
            }
        }
        return res;
    }

    // Compute hamming distance of two integers
    // O(1)
    private int hammingDistance(int a, int b) {
        return Integer.bitCount(a ^ b);
    }

    // Another way to look at this problem: 
    // For a specific bit, let's say there are m 1 bits and (n - m) 0 bits, that's (n - m) * m bits
    public int totalHammingDistance(int[] nums) {
        int res = 0;
        // Number of 1 bits in each position
        int[] bitCounts = new int[32];
        for (int num: nums) {
            int mask = 1;
            for (int j = 0; j < bitCounts.length; j++) {
                if ((mask & num) != 0) {
                    bitCounts[j]++;
                }
                mask = mask << 1;
            }
        }

        for (int count: bitCounts) {
            res += count * (nums.length - count);
        }

        return res;
    }

}