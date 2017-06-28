// Given a sorted array consisting of only integers where every element appears twice except for one element which appears once. Find this single element that appears only once.

// Example 1:
// Input: [1,1,2,3,3,4,4,8,8]
// Output: 2
// Example 2:
// Input: [3,3,7,7,10,11,11]
// Output: 10
// Note: Your solution should run in O(log n) time and O(1) space.

public class Solution {
    public int singleNonDuplicate(int[] nums) {
      int low = 0, high = nums.length - 1;
      while (low < high) {
        int mid = low + (high - low) / 2;
        int numMid = nums[mid];
        if (numMid == nums[mid - 1]) {
          if ((low + mid) % 2 == 0) {
            high = mid;
          } else {
            low = mid + 1
          }
        } else if (numMid == nums[mid + 1]) {
          if ((mid + high) % 2 != 0) {
            high = mid - 1;
          } else {
            low = mid;
          }
        } else {
          return numMid;
        }
      }

      return low;
    }
}