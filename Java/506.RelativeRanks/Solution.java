// Copy and sort the copied input array, iterate over it and put each score and  
// ranking into a map, finally traverse the original array and put their ranking
// into the result array.

public class Solution {

    // Beats 95%
    public String[] findRelativeRanks(int[] nums) {
        int len = nums.length;
        int[] copy = new int[len];
        String[] res = new String[len];
        Map<Integer, String> scoreToRank = new HashMap<>();

        System.arraycopy(nums, 0, copy, 0, len);
        // nums.clone() can do the work also
        Arrays.sort(copy);
        
        for (int i = len - 1; i >= 0; i--) {
            if (i == len - 1) {
                scoreToRank.put(copy[i], "Gold Medal");
            } else if (i == len - 2) {
                scoreToRank.put(copy[i], "Silver Medal");
            } else if (i == len - 3) {
                scoreToRank.put(copy[i], "Bronze Medal");
            } else {
                scoreToRank.put(copy[i], String.valueOf(len - i));
            }
        }

        for (int i = 0; i < len; i++) {
            res[i] = scoreToRank.get(nums[i]);
        }

        return res;
    }

}