// You are a professional robber planning to rob houses along a street. Each house has a certain 
// amount of money stashed, the only constraint stopping you from robbing each of them is that 
// adjacent houses have security system connected and it will automatically contact the police if 
// two adjacent houses were broken into on the same night.

// Given a list of non-negative integers representing the amount of money of each house, determine 
// the maximum amount of money you can rob tonight without alerting the police.

public class Solution {

    // First attempt: 
    // Bottom-up DP. O(n) space and time, pretty verbose, let's see if we could do better.
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        int[] rob = new int[nums.length];
        int[] notRob = new int[nums.length];
        // For each house, we either rob it, or we do not. 
        // rob[i] = max(rob[i-2], notrob[i-1])
        rob[0] = nums[0];
        rob[1] = Math.max(nums[0], nums[1]);
        notRob[1] = nums[0];
        for (int i = 2; i < nums.length; i++) {
            rob[i] = Math.max(rob[i-2], notRob[i-1]) + nums[i];
            notRob[i] = Math.max(rob[i-1], notRob[i-1]);
        }

        return Math.max(rob[nums.length-1], notRob[nums.length-1]);
    }

    // Let's try to get rid of the O(n) space.
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        int robPrev = nums[0]; // rob[i-2]
        int rob = Math.max(nums[0], nums[1]); // rob[i-1]
        int notRob = nums[0]; // notRob[i-1]

        for (int i = 2; i < nums.length; i++) {
            int temp = rob;
            rob = Math.max(robPrev, notRob) + nums[i];
            robPrev = temp;
            notRob = Math.max(temp, notRob);
        }

        return Math.max(rob, notRob);
    }

    // Actually, the compare of rob[i] = Math.max(rob[i-2], notRob[i-1]) + nums[i]; could be more 
    // concise because rob[i-2] is included in notRob[i-1] since: 
    // notRob[i-1] = Math.max(rob[i-1], notRob[i-1]);
    public int rob(int[] nums) {

        // rob[i] denotes that the max amount of cash we can collect if we decide to rob hosue i.
        int[] rob = new int[nums.length + 1];
        // notRob[i] denotes that the max amount of cash we can collect if we decide not to rob 
        // house i.
        int[] notRob = new int[nums.length + 1];

        for (int i = 1; i <= nums.length; i++) {
            rob[i] = notRob[i-1] + nums[i-1];
            notRob[i] = Math.max(rob[i-1], notRob[i-1]);
        }

        return Math.max(rob[nums.length], notRob[nums.length]);
    }

    // We can easily get rid of the constant space from the above solution
    public int rob(int[] nums) {
        // rob and notRob means that if the max amount of cash we can collect if we rob/not rob the 
        // previous house.
        int rob = 0, notRob = 0;
        
        for (int i = 0; i < nums.length; i++) {
            int curRob = notRob + nums[i];
            notRob = Math.max(rob, notRob);
            rob = curRob;
        }

        return Math.max(rob, notRob);
    }
}