public class Solution {
	// Find the max and min, 
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int medium = nums[nums.length / 2];
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
        	res += Math.abs(nums[i] - medium);
        }
        return res;
    }
}