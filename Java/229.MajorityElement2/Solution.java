import java.util.ArrayList;
import java.util.List;
public class Solution {
	
	//Return empty list if there is none
    public List<Integer> majorityElement(int[] nums) {
    	List<Integer> resList = new ArrayList<>();
    	if(nums == null || nums.length == 0) return resList;
    	int cand1 = nums[0], cand2 = nums[0]; //2 different candidates
    	int count1 = 0, count2 = 0;
    	for(int i = 0; i < nums.length; i++) {
    		if(nums[i] == cand1) {
    			count1++;
    		} else if(nums[i] == cand2) {
    			count2++;
    		} else if(count1 == 0) {
    			cand1 = nums[i];
    			count1++;
    		} else if(count2 == 0) {
    			cand2 = nums[i];
    			count2++;
    		} else {
    			count1--;
    			count2--;
    		}
    	}
    	
    	//Validate
    	count1 = 0;
    	count2 = 0;
    	for(int i = 0; i < nums.length; i++) {
    		if(nums[i] == cand1)
    			count1++;
    		else if(nums[i] == cand2)
    			count2++;
    	}
    	
    	if(count1 > nums.length / 3) resList.add(cand1);
    	if(count2 > nums.length / 3) resList.add(cand2);
    	
    	return resList;
    }
    
}