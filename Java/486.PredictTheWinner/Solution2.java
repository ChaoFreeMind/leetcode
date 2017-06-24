public class Solution {
    public boolean PredictTheWinner(int[] nums) {
      // Player 1 can always choose the larger number
      if (nums.length <= 2) return true;
      return helper(nums, 0, nums.length - 1, 0, 0);
    }

    private boolean helper(int[] nums, int low, int high, int myScore, int oppoScore) {
      if (high - low == 1) {
        int bigger = Math.max(nums[low], nums[high]);
        int smaller = Math.min(nums[low], nums[high]);
        return myScore + bigger >= oppoScore + smaller;
      }
      boolean oppoWinIfLow = helper(nums, low + 1, high, oppoScore,myScore + nums[low]);
      boolean oppoWinIfHigh = helper(nums, low, high - 1, oppoScore, myScore + nums[high]);
      return !oppoWinIfLow || !oppoWinIfHigh;
    }

}