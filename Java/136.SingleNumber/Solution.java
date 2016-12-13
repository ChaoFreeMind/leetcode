public class Solution {

	// O(n) time and space
    // public int singleNumber(int[] nums) {	
    // 	Set<Integer> set = new HashSet<>();
    // 	for (int i = 0; i < nums.length; i++) {
    // 		if(!set.add(nums[i])) set.remove(nums[i]);
    // 	}
    // 	// In the end the set should contain only one element
    // 	Iterator<Integer> iter = set.iterator();
    // 	return iter.next();
    // }

    // XOr: a xor a = 0 / a xor 0 = a
    public int singleNumber(int[] nums) {
    	int res = 0;
    	for (int num: nums) {
    		res ^= num;
    	}
    	return res;
    }

}