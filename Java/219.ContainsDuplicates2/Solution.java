public class Solution {

    // Naive way
    // public boolean containsNearbyDuplicate(int[] nums, int k) {
    // 	if (nums == null || nums.length == 0) return false;
    // 	Map<Integer, Integer> map = new HashMap<>();
    // 	for (int i = 0; i < nums.length; i++) {
    // 		if (map.containsKey(nums[i])) {
    // 			int last = map.get(nums[i]);
    // 			if (i - last <= k) return true;
    // 		}
    // 		map.put(nums[i], i);
    // 	}
    // 	return false;
    // }

    // Improved sliding window way
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<Integer>();
        for(int i = 0; i < nums.length; i++){
            if(i > k) set.remove(nums[i-k-1]);
            if(!set.add(nums[i])) return true;
        }
        return false;
 }
}