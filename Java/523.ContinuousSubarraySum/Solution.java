// Given a list of non-negative numbers and a target integer k, write a 
// function to check if the array has a continuous subarray of size at least 2 
// that sums up to the multiple of k, that is, sums up to n*k where n is also 
// an integer.

// Example 1:
// Input: [23, 2, 4, 6, 7],  k=6
// Output: True
// Explanation: Because [2, 4] is a continuous subarray of size 2 and sums up to 6.
// Example 2:
// Input: [23, 2, 6, 4, 7],  k=6
// Output: True
// Explanation: Because [23, 2, 6, 4, 7] is an continuous subarray of size 5 
// and sums up to 42.
// Note:
// The length of the array won't exceed 10,000.
// You may assume the sum of all the numbers is in the range of a signed 
// 32-bit integer.
public class Solution {

    // What if there is an array that sums up to 0 ?

    public boolean checkSubarraySum(int[] nums, int k) {
        // Corner cases
        if (nums.length < 2) {
            return false;
        }

        // Conatant naming in Java?
        int n = nums.length;
        // dp[i][j] denotes the sum from i to j
        int[] sum = new int[n]; // 1 based
        sum[0] = nums[0];
        for (int i = 1; i < n; i++) {
            sum[i] = sum[i-1] + nums[i];
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j - i + 1 >= 2) {
                    int subSum = sum[j] - sum[i] + nums[i];
                    if (k == 0 && subSum == 0 || k != 0 && subSum % k == 0) {
                        return true;
                    }
                }
            }
        }

        return false;
    }
}