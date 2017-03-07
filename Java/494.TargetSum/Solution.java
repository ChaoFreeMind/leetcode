// Backtracking, compute result on the fly
// You are given a list of non-negative integers, a1, a2, ..., an, and a target, S. Now you have 2 symbols + and -. For each integer, you should choose one from + and - as its new symbol.

// Find out how many ways to assign symbols to make sum of integers equal to target S.

// Example 1:
// Input: nums is [1, 1, 1, 1, 1], S is 3. 
// Output: 5
// Explanation: 

// -1+1+1+1+1 = 3
// +1-1+1+1+1 = 3
// +1+1-1+1+1 = 3
// +1+1+1-1+1 = 3
// +1+1+1+1-1 = 3

// There are 5 ways to assign symbols to make the sum of nums be target 3.
// Note:
// The length of the given array is positive and will not exceed 20.
// The sum of elements in the given array will not exceed 1000.
// Your output answer is guaranteed to be fitted in a 32-bit integer.

public class Solution {

    private int res = 0;

    public int findTargetSumWays(int[] nums, int S) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        backtrack(nums, 0, S, 0);
        return res;
    }

    private void backtrack(int[] nums, int sum, int target, int idx) {
        if (idx >= nums.length) {
            if (sum == target) res++;
            return;
        }
        backtrack(nums, sum + nums[idx], target, idx + 1);
        backtrack(nums, sum - nums[idx], target, idx + 1);
    }

}