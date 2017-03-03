// Given scores of N athletes, find their relative ranks and the people with 
// the top three highest scores, who will be awarded medals: "Gold Medal", 
// "Silver Medal" and "Bronze Medal".

// Example 1:
// Input: [5, 4, 3, 2, 1]
// Output: ["Gold Medal", "Silver Medal", "Bronze Medal", "4", "5"]
// Explanation: The first three athletes got the top three highest scores, 
// so they got "Gold Medal", "Silver Medal" and "Bronze Medal". 
// For the left two athletes, you just need to output their relative ranks 
// according to their scores.
// Note:
// N is a positive integer and won't exceed 10,000.
// All the scores of athletes are guaranteed to be unique.
public class Solution {

    private static final String GOLD = "Gold Medal";
    private static final String SILVER = "Silver Medal";
    private static final String BRONZE = "Bronze Medal";

    public String[] findRelativeRanks(int[] nums) {
        int len = nums.length;
        String[] res = new String[len];
        int[] sorted = new int[len];
        System.arraycopy(nums, 0, sorted, 0, len);

        // O(nlgn)
        Arrays.sort(sorted);
        // Map score to rank
        Map<Integer, String> map = new HashMap<>();

        // O(n)
        for (int i = len - 1; i >= 0; i--) {
            if (i == len - 1) {
                map.put(sorted[i], GOLD);
            } else if (i == len - 2) {
                map.put(sorted[i], SILVER);
            } else if (i == len - 3) {
                map.put(sorted[i], BRONZE);
            } else {
                map.put(sorted[i], String.valueOf(len - i));
            }
        }

        // O(n)
        for (int i = 0; i < len; i++) {
            res[i] = map.get(nums[i]);
        }

        return res;
    }
}