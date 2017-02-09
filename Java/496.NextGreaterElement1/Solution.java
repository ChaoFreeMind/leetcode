
public class Solution {
    // 1. For each number in nums1, do the scan to locate the number in nums2, and 
    //    then keep looking for the first number that is bigger than it.    
    public int[] nextGreaterElement(int[] findNums, int[] nums) {
        int[] res = new int[findNums.length];
        int idx = 0;

        for (int i = 0; i < findNums.length; i++) {
            int target = findNums[i];
            int j = 0;
            
            // Find the current number in the second array            
            while (nums[j] != target) j++;

            // Keep going until find the first number in second array that is 
            // greater than the first one.
            while (j < nums.length && nums[j] <= target) j++;

            // Here we either have not found a number or we have found one

            // Found it
            if (j < nums.length && nums[j] > target) {
                res[idx++] = nums[j];
            } else {
                res[idx++] = -1;
            }

        }

        return res;
    }

    // 2. First of all, let us focus on nums, what we can do is that we create 
    // a stack to keep track of the visited numbers, everytime we come across a 
    // new number, we first compare it to the top of stack, it it is greater than
    // the top of stack, then it means that we have found the target number for 
    // the top of stack, so we put them into a map. After the whole process, we 
    // have a map of all numbers in nums with their first greater number. 
    // The thing left for us to do is just go through findNums and build the final
    // result.
    public int[] nextGreaterElement(int[] findNums, int[] nums) {
        int[] res = new int[findNums.length];
        Deque<Integer> stack = new ArrayDeque<>();

        // Map number to the first number that is greater than it
        Map<Integer, Integer> map = new HashMap<>(); 

        for (int num: nums) {
            while (!stack.isEmpty() && stack.peek() < num) {
                int top = stack.pop();
                map.put(top, num);
            }
            stack.push(num);
        }

        for (int i = 0; i < findNums.length; i++) {
            res[i] = map.getOrDefault(findNums[i], -1);
        }

        return res;
    }
}