// Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice 
// and others appear once.

// Find all the elements of [1, n] inclusive that do not appear in this array.

// Could you do it without extra space and in O(n) runtime? You may assume the returned list does 
// not count as extra space.

// Example:

// Input:
// [4,3,2,7,8,2,3,1]

// Output:
// [5,6]
public class Solution {
    // Very tricky problem, I don't think it should be catigorized as easy!!
    // For every element in nums, we try to take it as an index and negate the relating element in 
    // nums. If there are no missing numbers in nums, all elements will be negative. After first  
    // iteration, there will be some numbers that are still positive which means their index are not
    // in nums.
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();

        for (int num: nums) {
            int idx = Math.abs(num) - 1;
            if (nums[idx] > 0) {
                nums[idx] = -nums[idx];
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                res.add(i + 1);
            }
        }

        return res;
    }
}