//Pattern Finding!
public class Solution {
	public void nextPermutation(int[] nums) {
		//1. Find the biggest index k, such that nums[k] < nums[k+1]
		int k = -1;
		for(int i = 0; i < nums.length - 1; i++) {
			if(nums[i] < nums[i+1]) k = i;
		}
		//k == -1 means the original array is in descending order, just reverse it.
		if(k != -1) {
			// 2. Find the biggest index m that is bigger than nums[k]
			int m = 0;//If k is not -1, m must have a value cuz nums[k] < nums[k+1]
			for (int i = k + 1; i < nums.length; i++) {
				if (nums[i] > nums[k])
					m = i;
			}

			swap(nums, m, k);
		}
		
		//3. Reverse [k+1, end]
		reverse(nums, k+1, nums.length - 1);
		
    }
	
	private void reverse(int[] nums, int from, int to) {
		while(from < to) swap(nums, from++, to--);
	}
	
	private void swap(int[] nums, int a, int b) {
		int temp = nums[a];
		nums[a] = nums[b];
		nums[b] = temp;
	}
}
