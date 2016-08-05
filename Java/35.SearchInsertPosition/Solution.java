public class Solution {
    public int searchInsert(int[] nums, int target) {
		
		int lo = 0, hi = nums.length - 1;
		int res = -1;
		while(lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			if(nums[mid] == target) {
				//Found the result, stop searching
				res = mid;
				break;
			} else if(nums[mid] > target) {
				hi = mid - 1;
			} else { //nums[mid] < target
				lo = mid + 1;
			}
		}
		
		if(res == -1) res = lo;
		
		return res;
    }
}