public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] res = {-1, -1};
        
        if (numbers.length == 0) return res;

        int left = 0, right = numbers.length - 1;

        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum < target) {
                left++;
            } else if (sum > target) {
                right--;
            } else {
                res[0] = left;
                res[1] = right;
                break;
            }
        }

        return res;
    }
}