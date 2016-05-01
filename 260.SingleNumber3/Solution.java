public class Solution {
    public int[] singleNumber(int[] nums) {
        //For the first pass, we xor everything to get the result of a xor b. Once we get the result, there must be at least one bit that are different.
    	//Split all numbers into 2 groups according to the different bit. XOR them together to find the result a and b
    	int diff = 0;
    	for(int i = 0; i < nums.length; i++) {
    		diff ^= nums[i];
    	}
    	diff = Integer.lowestOneBit(diff);//Get the lowest one bit!
    	int[] result = new int[2];
    	for(int i = 0; i < nums.length; i++) {
    		if((diff & nums[i]) == 0) {
    			result[0] ^= nums[i];
    		} else {
    			result[1] ^= nums[i];
    		} 
    	}
    	return result;
    }
}