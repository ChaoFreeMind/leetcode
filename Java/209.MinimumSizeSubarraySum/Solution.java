public class Solution {
    //Sliding window
	public int minSubArrayLen(int s, int[] nums) {
    	if(nums == null || nums.length == 0) return 0;
		int left = 0, right = 0;
		int sum = 0;
		int minSize = Integer.MAX_VALUE;
		//Left will not move faster than right
    	while(right < nums.length) {
    		
    		//right < nums.length is nessary because if we have a s whose value is bigger than all elements combined, right will go overbound!
    		while(sum < s && right < nums.length) {
    			sum += nums[right];
    			right++;
    		}
    		
    		while(sum >= s) {
    			minSize = Math.min(minSize, right - left);
    			sum -= nums[left];
    			left++;
    		}
    	}
    	
    	return minSize == Integer.MAX_VALUE ? 0: minSize;
    }
    
}