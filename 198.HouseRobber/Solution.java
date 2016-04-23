public class Solution {
	
	//dp[i] = max(dp[i-1], dp[i-2] + nums[i])
    /*public int rob(int[] nums) {
    	if(nums == null || nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for(int i = 2; i < nums.length; i++) {
        	dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i]);
        }
        
        return dp[nums.length - 1];
    }*/
    
    //Optimized
    public int rob(int[] nums) {
    	int prevrob = 0;//Max money we can get if we rob current house
    	int prevnotrob = 0;//Max money we can get if we do not rob current house
    	//Go through nums
    	for(int i = 0; i < nums.length; i++) {
    		int curnotrob = Math.max(prevrob, prevnotrob);//If we do not rob current house, then the max money would be the max value between rob previous and not rob previous
    		int currob = prevnotrob + nums[i]; //If we decide to rob current house, then the max money would be 
    		//the max money we can get if we do not rob previous house plus the money we can get for current house
    		
    		prevrob = currob;
    		prevnotrob = curnotrob;
    	}
    	return Math.max(prevrob, prevnotrob);
    }
}