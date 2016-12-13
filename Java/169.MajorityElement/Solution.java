import java.util.Arrays;

public class Solution {
    // Sort array, the element in the middle must be the majority one.
    // public int majorityElement(int[] nums) {
    //  // Dual pivot quick sort Average time: O(nlgn) Space: O(lgn) (improved) or O(n) (naive)
    //     Arrays.sort(nums);
    //     return nums[nums.length / 2];
    // }

    // Hashmap
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num: nums) {
            int count = map.getOrDefault(num, 0) + 1;
            if (count > nums.length / 2) return num;
            map.put(num, count);
        }
        // Not found
        return Integer.MIN_VALUE;
    }

    // You may assume that the array is non-empty and the majority element always exist in the array.
    // O(n) time O(1) space
    public int majorityElement(int[] nums) {
        int ans = nums[0], count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == ans) {
                count++;
            } else {
                if (--count == 0) {
                    ans = nums[i];
                    count = 1;
                }
            }
        }
        return ans;
    }
    
    //Moore voting algorithm
    public int majorityElement(int[] nums) {
    	int counter = 0, major = nums[0];
    	for(int i = 0; i < nums.length; i++) {
    		if(counter == 0) {
    			major = nums[i];
    			counter++;
    		} else if(major == nums[i]) {
    			counter++;
    		} else {
    			counter--;
    		}
    	}
    	
    	return major;
    }
}