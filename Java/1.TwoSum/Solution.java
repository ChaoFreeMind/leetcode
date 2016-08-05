import java.util.HashMap;
import java.util.Map;

//Given an array of integers, return indices of the two numbers such that they add up to a specific target.
//
//You may assume that each input would have exactly one solution.
//
//Example:
//Given nums = [2, 7, 11, 15], target = 9,
//
//Because nums[0] + nums[1] = 2 + 7 = 9,
//return [0, 1].
public class Solution {
	
    //The purpose of map is more clear: Storing each of the visited element.
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            //For each element we are currently visiting, check if it can 
            //match with a previously visited element.
            if(map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        
        
        return new int[]{0, 0};
    }

    public int[] twoSum(int[] nums, int target) {
        int[] ret = new int[2];
        Map<Integer, Integer> map = new HashMap<>();//Keeps track of the elements that is missing.
        for(int i = 0; i < nums.length; i++) {
        	if(map.containsKey(nums[i])) {
                //If there is a match in hash table, it means we have found the missing element.
        		ret[0] = i;
        		ret[1] = map.get(nums[i]);
        		break;
        	} else {
                //Otherwise, we put the expecting element into our map.
        		map.put(target - nums[i], i);
        	}
        }
        
        return ret;
    }


}