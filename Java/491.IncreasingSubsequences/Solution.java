// Given an integer array, your task is to find all the different possible increasing subsequences 
// of the given array, and the length of an increasing subsequence should be at least 2 .

// Example:
// Input: [4, 6, 7, 7]
// Output: [[4, 6], [4, 7], [4, 6, 7], [4, 6, 7, 7], [6, 7], [6, 7, 7], [7,7], [4,7,7]]
// Note:
// The length of the given array will not exceed 15.
// The range of integer in the given array is [-100,100].
// The given array may contain duplicates, and two equal integers should also be considered as a 
// special case of increasing sequence.

// Backtracking
// Test cases: 1. [1, 2, 3] 2. [] 3. [4, 6, 7, 7]
public class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        Set<List<Integer>> resSet = new HashSet<>();
        List<Integer> res = new ArrayList<>();

        backtrack(resSet, res, nums, 0);

        return new ArrayList<>(resSet);
    }

    private void backtrack(Set<List<Integer>> resSet, List<Integer> res, int[] nums, int pos) {

        if (res.size() >= 2) {
            resSet.add(new ArrayList<>(res));
        }
        
        for (int i = pos; i < nums.length; i++) {
            if (res.size() == 0 || res.get(res.size() - 1) <= nums[i]) {
                res.add(nums[i]);
                backtrack(resSet, res, nums, i + 1);
                res.remove(res.size() - 1);
            }
        }
    }
}