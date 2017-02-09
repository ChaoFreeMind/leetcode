public class Solution {
	// Naive
    public int[] twoSum(int[] nums, int target) {
    	int[] res = new int[2];
   		for (int i = 0; i < nums.length - 1; i++) {
   			for (int j = i + 1; j < nums.length; j++) {
   				if (nums[i] + nums[j] == target) {
   					res[0] = i;
                    res[1] = j;
   					return res;
   				}
   			}
   		}
   		return res;
    }

    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(target - nums[i], i);
            } else {
                
                res[0] = map.get(nums[i]);
                res[1] = i;
                break;
            }
        }
        return res;
    }
}