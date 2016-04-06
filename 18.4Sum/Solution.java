import java.util.ArrayList;
import java.util.List;

//Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.
//
//Note:
//Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ≤ b ≤ c ≤ d)
//The solution set must not contain duplicate quadruplets.
//    For example, given array S = {1 0 -1 0 -2 2}, and target = 0.
//
//    A solution set is:
//    (-1,  0, 0, 1)
//    (-2, -1, 1, 2)
//    (-2,  0, 0, 2)
public class Solution {
	
	//A little bit complicated!!
	//Similar 3sum approach: https://leetcode.com/discuss/67914/easiest-java-solution
	public List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> resList = new ArrayList<>();
		if(nums == null || nums.length < 4) return resList;
		for(int i = 0; i < nums.length - 3; i++) {
			//First Number nums[i]
			if(i > 0 && nums[i] == nums[i-1]) continue;//Deduplicate
			for(int j = i + 1; j < nums.length - 2; j++) {
				//Second Number nums[j]
				if(j > 1 && nums[j] == nums[j-1]) continue;//Deduplicate
				int low = j + 1, high = nums.length - 1;
				while(low < high) {
					int sum = nums[i] + nums[j] + nums[low] + nums[high]; 
					if(sum == target) {
						List<Integer> res = new ArrayList<>();
						res.add(nums[i]);
						res.add(nums[j]);
						res.add(nums[low]);
						res.add(nums[high]);
						resList.add(res);
						int third = nums[low], fourth = nums[high];
						while(low < high && third == nums[low+1]) low++;//Deduplicate
						while(low < high && fourth == nums[high-1]) high--;//Deduplicate
						low++;
						high--;
					} else if(sum < target) {
						low++;
					} else {
						high--;
					}
				}
			}
			
		}
		
		return resList;
    }
}
