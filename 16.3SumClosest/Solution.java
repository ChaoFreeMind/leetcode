public class Solution {
	
	public int threeSumClosest(int[] nums, int target) {
		Arrays.sort(nums);
		int minDiff = Integer.MAX_VALUE;
		int result = 0;//??
		//Trying to find the first one
		for(int i = 0; i < nums.length - 2; i++) {
			int low = i + 1, high = nums.length - 1;
			int first = nums[i];
			while(low < high) {
				int sum = first + nums[low] + nums[high];
				if(Math.abs(target - sum) < minDiff) {
					result = sum;
					minDiff = Math.abs(target - sum);
				}
				
				if(sum < target) {
					low++;
				} else if(sum > target) {
					high--;
				} else {
					return target;
				}
				
				
			}
		}
		return result;
		
	}
}