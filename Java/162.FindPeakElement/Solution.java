public class Solution {
    //Assume there is at least one peak element in the array.
    public int findPeakElement(int[] nums) {
        //Binary search
    	int left = 0, right = nums.length - 1;
    	
    	while(left < right) {
    		int mid = left + (right - left) / 2;
    		
    		if(mid == left) {//2 elements situation
    			if(nums[mid] < nums[mid+1]) return mid + 1;
    			return mid;
    		}
    		//Found
    		if(nums[mid] > nums[mid+1] && nums[mid] > nums[mid-1]) {
    			return mid;
    		}//nums[mid-1] < nums[mid] < nums[mid+1] search right
    		else if(nums[mid-1] < nums[mid] && nums[mid] < nums[mid+1]) {
    			//Search right
    			left = mid + 1;
    		} else {
    			//Including
    			//nums[mid-1] > nums[mid] > nums[mid+1] search left
        		//nums[mid-1] > nums[mid] < nums[mid+1] both sides have the peak element
    			//search left
    			right = mid - 1;
    		}		
    	}
    	
    	return left;
    }
}