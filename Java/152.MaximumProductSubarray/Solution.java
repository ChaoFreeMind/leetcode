public class Solution {
	
	//Standard solution
    /*public int maxProduct(int[] nums) {
    	int[] minArr = new int[nums.length];//minimum contiguous subarray product including i
    	int[] maxArr = new int[nums.length];
    	minArr[0] = nums[0];
    	maxArr[0] = nums[0];
    	int max = nums[0];
    	
    	for(int i = 1; i < nums.length; i++) {
    		minArr[i] = Math.min(Math.min(nums[i], maxArr[i-1] * nums[i]), minArr[i-1] * nums[i]);
    		maxArr[i] = Math.max(Math.max(nums[i], minArr[i-1] * nums[i]), maxArr[i-1] * nums[i]);
    		max = Math.max(maxArr[i], max);
    	}
    	
    	return max;
    }*/
    
    //Improvement
    public int maxProduct(int[] nums) {
    	int iMin = nums[0], iMax = nums[0], max = nums[0];
    	
    	for(int i = 1; i < nums.length; i++) {
    		int iMinTemp = Math.min(Math.min(nums[i] * iMax, nums[i] * iMin), nums[i]);
    		int iMaxTemp = Math.max(Math.max(nums[i] * iMin, nums[i] * iMax), nums[i]);
    		iMin = iMinTemp;
    		iMax = iMaxTemp;
    		max = Math.max(iMax, max);
    	}
    	
    	return max;
    }
    
}