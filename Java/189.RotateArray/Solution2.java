public class Solution {
	// 1. O(n) time O(k) space
    public void rotate(int[] nums, int k) {
    	int n = nums.length;
    	k = k % n;
        int[] temp = new int[k];
        // System.arraycopy(src, idx1, dest, idx2, len);
        System.arraycopy(nums, n - k, temp, 0, k);
        System.arraycopy(nums, 0, nums, k, n - k);
        System.arraycopy(temp, 0, nums, 0, k);
    }

    // 2. Reverse first (n - k) elements then reverse last k, finally reverse the final result
    public void rotate(int[] nums, int k) {
    	int n = nums.length;
    	k = k % n;
    	reverse(nums, 0, n - k - 1);
    	reverse(nums, n - k, n - 1);
    	reverse(nums, 0, n - 1);
    }

    // Reverse nums[from, to]
    private void reverse(int[] nums, int from, int to) {
    	while (from < to) {
    		// Swap from and to
    		int temp = nums[from];
    		nums[from] = nums[to];
    		nums[to] = temp;
    		from++;
    		to--;
    	}
    }

    // 3. Cycle sort inspired by https://discuss.leetcode.com/topic/9206/my-two-o-n-solutions-with-o-1-extra-memory-i-don-t-know-the-third-one-yet-any-idea/3
    public void rotate(int[] nums, int k) {
    	
    }

}