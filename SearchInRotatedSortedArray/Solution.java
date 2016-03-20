//Suppose a sorted array is rotated at some pivot unknown to you beforehand.
//
//(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
//
//You are given a target value to search. If found in the array return its index, otherwise return -1.
//
//You may assume no duplicate exists in the array.
public class Solution {
	//Discuss in case of different situations 
	public int search(int[] nums, int target) {
		
		if(nums == null || nums.length == 0) return -1;
		
		int low = 0, high = nums.length - 1;
		
		while(low <= high) {
			int mid = low + high - low / 2;
			
			if(nums[mid] == target) {
				return mid;
			}
			
			if(nums[mid] < nums[low]) {
				//right side is sorted
				if(target > nums[mid] && target <= nums[high]) {
					low = mid + 1;
				} else {
					high = mid - 1;
				}
			} else {//nums[mid] > nums[low]
				//left side is sorted
				if(target < nums[mid] && target >= nums[low]) {
					high = mid - 1;
				} else {
					low = mid + 1;
				}
			}
			
		}
		
		return -1;
    }
	
}
