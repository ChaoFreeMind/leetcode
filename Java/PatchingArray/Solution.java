//Total Accepted: 5997 Total Submissions: 20902 Difficulty: Medium

//Given a sorted positive integer array nums and an integer n, add/patch elements to the array 
//such that any number in range [1, n] inclusive can be formed by the sum of some elements in the array. 
//Return the minimum number of patches required.
//
//Example 1:
//nums = [1, 3], n = 6
//Return 1.
//
//Combinations of nums are [1], [3], [1,3], which form possible sums of: 1, 3, 4.
//Now if we add/patch 2 to nums, the combinations are: [1], [2], [3], [1,3], [2,3], [1,2,3].
//Possible sums are 1, 2, 3, 4, 5, 6, which now covers the range [1, 6].
//So we only need 1 patch.
//
//Example 2:
//nums = [1, 5, 10], n = 20
//Return 2.
//The two patches can be [2, 4].
//
//Example 3:
//nums = [1, 2, 2], n = 5
//Return 0.
public class Solution {
	
	public int minPatches(int[] nums, int n) {
		if(nums == null) throw new IllegalArgumentException("Array should not be null and n should be at least greater than one");
		int patch = 0;
		long maxReach = 0;
		for(int i = 0; maxReach < n; ) {
			if(i >= nums.length || maxReach < nums[i] - 1) {
				//i>=nums.length: 1,2,3 n = 10: maxReach == 6 then we should patch maxReach + 1 which makes maxReach to maxReach += maxReach + 1
				//maxReach < nums[i] - 1: maxReach 8 nums[i] = 10 then we need to patch a 9 to our array
				maxReach += maxReach + 1;
				patch++;
			} else {
				maxReach += nums[i];
				i++;
			}
		}
		
		return patch;
	}	
}
