public class Solution {
    //Tricky
	public void sortColors(int[] nums) {
    	
    	int zero = 0, two = nums.length - 1;
    	
    	for(int i = 0; i <= two; i++) {
    		if(nums[i] == 2) {
    			nums[i] = nums[two];
    			nums[two] = 2;
    			two--;
    			i--;//Recheck current element
    		} else if(nums[i] == 0) {
    			nums[i] = nums[zero];
    			nums[zero] = 0;
    			zero++;
    		}
    	}
    }
}