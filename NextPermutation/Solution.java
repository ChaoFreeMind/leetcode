//The Algorithm to generate the next lexicographically larger permutation.
//The following algorithm generates the next permutation lexicographically after a given permutation. It changes the given permutation in-place.
//
//Find the largest index k such that a[k] < a[k + 1]. If no such index exists, the permutation is the last permutation.
//Find the largest index l greater than k such that a[k] < a[l].
//Swap the value of a[k] with that of a[l].
//Reverse the sequence from a[k + 1] up to and including the final element a[n].
public class Solution {

	public static void main(String[] args) {
		int[] nums = { 1, 3, 2 };
		new Solution().nextPermutation(nums);
		printArr(nums);

	}

	private static void printArr(int[] arr) {
		for (int i = 0; i < arr.length; i++) {

			System.out.print(arr[i]);

		}
	}

	public void nextPermutation(int[] nums) {

		// Find the first element such that nums[k] < nums[k+1], if there is
		// not, then we are at desc order, only need to reverse the whole array
		int k = -1;
		for (int i = 0; i < nums.length - 1; i++)
			if (nums[i] < nums[i + 1])
				k = i;
		
		if (k != -1) {
			int l = 0;
			for (int i = k; i < nums.length; i++)
				if (nums[k] < nums[i])
					l = i;

			swap(nums, k, l);

		}
		reverse(nums, k + 1, nums.length - 1);
	}

	private void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

	private void reverse(int[] nums, int from, int to) {

		while (from < to)
			swap(nums, from++, to--);

	}

}
