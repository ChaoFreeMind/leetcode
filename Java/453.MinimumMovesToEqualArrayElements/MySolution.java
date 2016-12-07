// Tricky and fun problem.
public class Solution {

	// Come on, read the problem!!
	// The number of moves is equal to the difference between max and min
    // public int minMoves(int[] nums) {
    //     Arrays.sort(nums);
    //     return nums[nums.length-1] - nums[0];
    // }

	//Check if all of elements in array is equal
	private boolean isArrayEqual(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i] != arr[i+1]) return false;
		}
		return true;
	}

	// Straightforward
    public int minMoves(int[] nums) {
    	int moves = 0, len = nums.length;
    	while (!isArrayEqual(nums)) {
    		Arrays.sort(nums);
    		int diff = nums[len-1] - nums[0];
    		for (int i = 0; i < len - 1; i++) {
	    		nums[i] += diff;
	    	}
	    	moves++;
    	}
    	return moves;
    }

}