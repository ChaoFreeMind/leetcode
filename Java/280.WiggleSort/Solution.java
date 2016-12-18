// Given an unsorted array nums, reorder it in-place such that nums[0] <= nums[1] >= nums[2] <= nums[3]....

// For example, given nums = [3, 5, 2, 1, 6, 4], one possible answer is [1, 6, 2, 5, 3, 4].

public class Solution {
	private void swap(int[] nums, int idx1, int idx2) {
		int temp = nums[idx1];
		nums[idx1] = nums[idx2];
		nums[idx2] = temp;
	}
	// This is not in-place solution
 //    public void wiggleSort(int[] nums) {
 //        Arrays.sort(nums);
 //        for (int i = 1; i < nums.length - 1; i += 2) {
 //        	swap(i, i + 1);
 //        }
 //    }

	public void wiggleSort(int[] nums) {
		for (int i = 0; i < nums.length - 1; i++) {
			if ((i % 2 == 0) && (nums[i] > nums[i+1])) {
				swap(nums, i, i+1);
			} else if ((i % 2 != 0) && (nums[i] < nums[i+1])) {
				swap(nums, i, i+1);
			}
		}
	}
}