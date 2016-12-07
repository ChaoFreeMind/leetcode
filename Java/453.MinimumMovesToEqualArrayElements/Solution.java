// Tricky and fun problem.
public class Solution {
	// Math
	/*
	 Say we have to take a minumum of m steps to reach our goal,
	 and x is the final number we have to reach. 
	 The final state of our array would be [x,x,x].
	 Thus we have an equivalent: sum + m * (n-1) = x * n
	 and more we have: x - min = m
	 so after combining those two formulas we got ourselves the answer
	 m = sum - n * min
	 */
	 public int minMoves(int[] nums) {
	 	// find min
	 	int min = nums[0];
	 	long sum = nums[0];
	 	for (int i = 1; i < nums.length; i++) {
	 		min = Math.min(min, nums[i]);
	 		sum += nums[i];
	 	}
	 	// calc sum
	 	return Math.sum(nums) - nums.length * min;
	 } 

	 // Increasing n-1 numbers by one is equivalent to 
	 // subtracting one number by one.
	 public int minMoves(int[] nums) {
	 	int min = nums[0], moves = 0;
	 	for (int i = 1; i < nums.length; i++) {
	 		min = Math.min(min, nums[i]);
	 	}
	 	for (int = 0; i < nums.length; i++) {
	 		moves += nums[i] - min;
	 	}
	 	return moves;
	 }
}