import java.util.Arrays;

public class Solution {
	//O(nlgn) Time
    /*public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }*/
    
    //Moore voting algorithm
    public int majorityElement(int[] nums) {
    	int counter = 0, major = nums[0];
    	for(int i = 0; i < nums.length; i++) {
    		if(counter == 0) {
    			major = nums[i];
    			counter++;
    		} else if(major == nums[i]) {
    			counter++;
    		} else {
    			counter--;
    		}
    	}
    	
    	return major;
    }
}