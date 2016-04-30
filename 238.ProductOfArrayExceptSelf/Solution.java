public class Solution {
    //The idea is that first we fill output array with product from nums 0 to i-1
	//Then we start from the right hand side of the array, the actual output would be output[i] * right where right is the contiguous product starting from the right hand side.
    public int[] productExceptSelf(int[] nums) {
    	int[] output = new int[nums.length];
    	
    	output[0] = 1;
    	for(int i = 1; i < nums.length; i++) {
    		output[i] = output[i-1] * nums[i-1];
    	}
    	
    	int right = 1;
    	for(int i = nums.length - 1; i >= 0; i--) {
    		output[i] = right * output[i];
    		right *= nums[i];
    	}
    	
    	return output;
    }
    
}