public class Solution {
     public int findMin(int[] nums) {
    	if(nums == null || nums.length == 0) return Integer.MAX_VALUE;
    	int left = 0, right = nums.length - 1;
    	
    	while(left < right) {
    		int mid = left + (right - left) / 2;
    		if(nums[mid] >= nums[left] && nums[mid] > nums[right]) {//[2,1] [1,2]
    			//Then search the right part for min
    			left = mid + 1;
    		} else if(nums[mid] < nums[left] && nums[mid] < nums[right]) {
    			//Search left for min
    			right = mid;
    		} else {
    			//Not rotated
    			return nums[left];
    		}
    	}
    	
    	return nums[left];
    }
    
}