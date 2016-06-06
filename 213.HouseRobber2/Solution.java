public class Solution {

	public int rob(int[] nums) {
		if(nums == null || nums.length == 0) return 0;
		
		//If rob last one
		int robLast = rob(nums, 1, nums.length - 3) + nums[nums.length - 1];
		//If not rob last one
		int notRobLast = rob(nums, 0, nums.length - 2);
		return Math.max(robLast, notRobLast);
	}

	public int rob(int[] nums, int start, int end) {
		//Index out of bounds
		if(end < 0 || start > end) return 0;
		
		int rob = nums[start];
		int notrob = 0;
		for(int i = start + 1; i <= end; i++) {
			int curRob = notrob + nums[i];
			notrob = Math.max(notrob, rob);
			rob = curRob;
		}
		return Math.max(rob, notrob);
	}
}