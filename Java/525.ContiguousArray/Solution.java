public class Solution {

    // diffs[j] == diffs[i] where j > i then nums[i + 1, j] is the desired array
    public int findMaxLength(int[] nums) {
        if (nums.length == 0) return 0;

        // diffs[i] represents the number of 1s - the number of 0s until index i
        int[] diffs = new int[nums.length]; 

        // diffs[i] to i 
        Map<Integer, Integer> map = new HashMap<>();
        int maxLen = 0;
        // To handle case [0, 1]
        map.put(0, -1);
        
        diffs[0] = nums[0] == 1 ? 1 : -1;
        map.put(diffs[0], 0);
        for (int i = 1; i < nums.length; i++) {
            diffs[i] = diffs[i-1] + (nums[i] == 1 ? 1 : -1);
            if (map.containsKey(diffs[i])) {
                // Found a contiguous array
                maxLen = Math.max(maxLen, i - map.get(diffs[i]));
            } else {
                map.put(diffs[i], i);
            }
        }

        return maxLen;
    }


    // Convert diffs to 1 based index
    public int findMaxLength(int[] nums) {
        if (nums.length == 0) return 0;

        // diffs[i] represents the number of 1s - the number of 0s until index i
        int[] diffs = new int[nums.length + 1]; 

        // diffs[i] to i 
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);

        int maxLen = 0;

        for (int i = 1; i <= nums.length; i++) {
            diffs[i] = diffs[i-1] + (nums[i-1] == 1 ? 1 : -1);
            if (map.containsKey(diffs[i])) {
                // Found a contiguous array
                maxLen = Math.max(maxLen, i - map.get(diffs[i]));
            } else {
                map.put(diffs[i], i);
            }
        }

        return maxLen;
    }
}