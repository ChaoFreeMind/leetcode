import java.util.HashMap;
import java.util.Map;

//Given an array of integers and an integer k, 
//find out whether there are two distinct indices i and j in the array such that nums[i] = nums[j] and the difference between i and j is at most k.
public class Solution {
	
    public boolean containsNearbyDuplicate(int[] nums, int k) {
    	Map<Integer, Integer> map = new HashMap<>();//Map number in array to its index
    	for(int i = 0; i < nums.length; i++) {
    		if(map.containsKey(nums[i])) {
    			if(i - map.get(nums[i]) <= k) return true;
    			//If current i and its last occurrence is larger than k, we set it to i.
    		}
    		map.put(nums[i], i);
    	}
    	return false;
    }
    
}