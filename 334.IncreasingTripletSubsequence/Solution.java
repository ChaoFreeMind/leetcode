public class Solution {

    public boolean increasingTriplet(int[] nums) {
    	//3 4 1 5 
    	int first = Integer.MAX_VALUE, second = Integer.MAX_VALUE;
    	for(int i = 0; i < nums.length; i++) {
    		if(nums[i] <= first) {
    			first = nums[i];
    		} else if(nums[i] <= second) {
    			second = nums[i];
    		} else {
    			return true;
    		}
    	}
    	return false;
    }

}