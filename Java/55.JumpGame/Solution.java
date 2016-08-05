public class Solution {
	
	public static void main(String[] args) {
		int[] nums = {1,2,3};
		new Solution().canJump(nums);
	}
	
	//Jumping forward
	/*public boolean canJump(int[] nums) {
		int max = nums[0];//max index we can reach so far
		for(int i = 1; i < nums.length; i++) {
			//If we can not even reach current index, return false;
			if(max < i)
				return false;
			max = Math.max(max, i + nums[i]);
		}
		return true;
    }*/
	
	//Jumping backward
	public boolean canJump(int[] nums) {
		int goal = nums.length - 1;
		for(int i = nums.length - 2; i >= 0; i--) {
			if(i + nums[i] >= goal) goal = i;//If we can reach last from current index, then current index became our new goal. 
		}
		return goal == 0;
	}
	
}