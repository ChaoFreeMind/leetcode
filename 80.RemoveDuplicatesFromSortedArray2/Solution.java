public class Solution {
    public int removeDuplicates(int[] nums) {
    	int end = 1, cur = 1;
    	int count = 1;//Count the number of repeating elements
    	while(cur < nums.length) {
    		if(nums[cur] == nums[cur-1]) {
    			count++;
    			nums[end] = nums[cur];
    			if(count == 2) end++;
    		} else {
    			count = 1;
        		nums[end++] = nums[cur];
    		}		
    		cur++;
    	}
    	
        return end;
    }
}