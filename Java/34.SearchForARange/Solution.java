
public class Solution {
	
	public int[] searchRange(int[] nums, int target) {
		int[] range = {Integer.MAX_VALUE, Integer.MIN_VALUE};
		binarySearch(nums, 0, nums.length - 1, target, range);
		//Not found
		if(range[0] == Integer.MAX_VALUE && range[1] == Integer.MIN_VALUE) {
			range[0] = -1;
			range[1] = -1;
		}
		return range;
	}
	
	private void binarySearch(int[] nums, int lo, int hi, int target, int[] range) {
		
		if(lo > hi) return;
		
		int mid = lo + (hi - lo) / 2;
		if(nums[mid] == target) {
			if(mid < range[0]) {
				range[0] = mid;
				//Only have to keep expanding to the left!
				binarySearch(nums, lo, mid - 1, target, range);
			}
			
			if(mid > range[1]) {
				range[1] = mid;
				binarySearch(nums, mid + 1, hi, target, range);
			}
			
			//Previous code quite slow
//			range[0] = Math.min(range[0], mid);
//			range[1] = Math.max(range[1], mid);
//			binarySearch(nums, lo, mid - 1, target, range);
//			binarySearch(nums, mid + 1, hi, target, range);
		} else if(nums[mid] < target) {
			binarySearch(nums, mid + 1, hi, target, range);
		} else {//nums[mid] > target 
			binarySearch(nums, lo, mid - 1, target, range);
		}
		
	}
	
}
