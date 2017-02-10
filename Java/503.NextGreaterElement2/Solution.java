// This problem is almost the same as the NextGreaterElemnt1, the only challenge
// is that we need to keep track of the index of each node because there may be
// duplicates.

// A general technique of circular array is to expand the original array to the
// size of two.
public class Solution {

    class Node {
        int val;
        int idx;
        Node(int val, int idx) {
            this.val = val;
            this.idx = idx;
        }
    }

    public int[] nextGreaterElements(int[] nums) {
        int[] res = new int[nums.length];
        // Extend the array
        int[] extended = new int[nums.length * 2];
        System.arraycopy(nums, 0, extended, 0, nums.length);
        System.arraycopy(nums, 0, extended, nums.length, nums.length);

        // Map index in nums to its next greater number
        Map<Integer, Integer> map = new HashMap<>();
        Deque<Node> stack = new ArrayDeque<>();

        for (int i = 0; i < extended.length; i++) {
            while (!stack.isEmpty() && extended[i] > stack.peek().val) {
                Node top = stack.pop();
                map.put(top.idx, extended[i]);
            }
            stack.push(new Node(extended[i], i % nums.length));
        }

        // Build the result
        for (int i = 0; i < nums.length; i++) {
            res[i] = map.getOrDefault(i, -1);
        }

        return res;
    }
}