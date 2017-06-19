// Given an integer array, you need to find one continuous subarray that if you only sort this subarray in ascending order, then the whole array will be sorted in ascending order, too.

// You need to find the shortest such subarray and output its length.

// Example 1:
// Input: [2, 6, 4, 8, 10, 9, 15]
// Output: 5
// Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.
// Note:
// Then length of the input array is in range [1, 10,000].
// The input array may contain duplicates, so ascending order here means <=.

public class Solution {

    public int findUnsortedSubarray(int[] nums) {
      int[] temp = new int[nums.length];
      arrayCopy(nums, temp);
      int left = 0, right = nums.length - 1;
      int res = nums.length;
      Arrays.sort(temp);
      while(left < right) {
        res = Math.min(res, right - left + 1);
        
        if (nums[left] != temp[left] && nums[right] != temp[right]) {
          return res;
        }

        if (nums[left] == temp[left]) {
          left++;
        }
        if (nums[right] == temp[right]) {
          right--;
        }

      }

      return 0;
    }

    private void arrayCopy(int[] src, int[] dest) {
      for (int i = 0; i < src.length; i++) dest[i] = src[i];
    }
}