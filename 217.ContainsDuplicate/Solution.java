import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {
	
	//3 ways of solving this:
	//O(n^2) / O(1)
   /* public boolean containsDuplicate(int[] nums) {
    	if(nums == null || nums.length == 0) return false;
    	for(int i = 0; i < nums.length; i++) {
    		for(int j = i + 1; j < nums.length; j++) {
    			if(nums[i] == nums[j]) return true;
    		}
    	}
    	return false;
    }*/
	//O(n) time / O(n) space
	public boolean containsDuplicate(int[] nums) {
		Set<Integer> set = new HashSet<>();
		for(int i = 0; i < nums.length; i++) {
			if(!set.add(nums[i])) return true;
		}
		return false;
	}
	//O(nlgn) time / O(nlgn) stack frame space(Quick sort)
	/*public boolean containsDuplicates(int[] nums) {
		Arrays.sort(nums);
		for(int i = 0; i < nums.length - 1; i++) {
			if(nums[i] == nums[i+1]) return true;
		}
		return false;
	}*/
}