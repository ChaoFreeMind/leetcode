import java.util.Arrays;

public class Solution {
	// Time: O(n) Space: O(1) One-pass
	// According to the definition, when we are at odd index, n[i] >= n[i-1]
	// ; when we are at even index, n[i] <= n[i-1]
	public void wiggleSort(int[] nums) {

		for (int i = 1; i < nums.length; i++) {

			if ((i % 2 == 0 && nums[i] > nums[i - 1])
					|| (i % 2 != 0 && nums[i] < nums[i - 1])) {
				swap(nums, i, i - 1);
			}

		}

	}

	/*
	 * //Time: O(nlogn) Space: O(1) public void wiggleSort(int[] nums) {
	 * Arrays.sort(nums); for(int i = 2; i < nums.length; i+=2) { swap(nums, i,
	 * i-1); } }
	 */
	// Swap nums[a] and nums[b]
	private void swap(int[] nums, int a, int b) {
		int temp = nums[b];
		nums[b] = nums[a];
		nums[a] = temp;
	}

}
