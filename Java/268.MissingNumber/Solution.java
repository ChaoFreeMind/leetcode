public class Solution {
	//For each element in nums, xor them from 0 to n
    public int missingNumber(int[] nums) {
    	int res = 0;
    	for(int i = 0; i < nums.length; i++) {
    		res ^= i ^ nums[i];
    	}
    	
    	return res ^ nums.length;
    }
}