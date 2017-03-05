// Given a circular array (the next element of the last element is the first
// element of the array), print the Next Greater Number for every element. 
// The Next Greater Number of a number x is the first greater number to its 
// traversing-order next in the array, which means you could search circularly 
// to find its next greater number. If it doesn't exist, output -1 for this number.

// Example 1:
// Input: [1,2,1]
// Output: [2,-1,2]
// Explanation: The first 1's next greater number is 2; 
// The number 2 can't find next greater number; 
// The second 1's next greater number needs to search circularly, which is also 2.
// Note: The length of given array won't exceed 10000.
public class Solution {
    
    class Node {
        int index;
        int value;
        // Constructor
        Node (int index, int value) {
            this.index = index;
            this.value = value;
        }


        // Override
        public boolean equals(Node a, Node b) {
            return a.index == b.index && a.value == b.value;
        }

    }
    
    // For circular array, one technique we can do is to expand the original
    // array. To convert the index: (idx % len)
    // See 496.NextGreaterElements1 for why we use stack here.
    // The tricky part of this problem is that this problem has duplicates!
    public int[] nextGreaterElements(int[] nums) {
        int[] res = new int[nums.length];
        // Expand the array
        int[] expandedNums = expand(nums);

        Deque<Node> stack = new ArrayDeque<>();
        // Map index of nums[i] to its next greater number.
        Map<Integer, Integer> nextGreaterMap = new HashMap<>();

        for (int i = 0; i < expandedNums.length; i++) {
            while (!stack.isEmpty() && expandedNums[i] > stack.peek().value) {
                Node top = stack.pop();
                nextGreaterMap.put(top.index, expandedNums[i % expandedNums.length]);
            }
            stack.push(new Node(i % expandedNums.length, expandedNums[i]));
        }

        // Collect the result from nextGreaterMap!
        for (int i = 0; i < nums.length; i++) {
            res[i] = nextGreaterMap.getOrDefault(i, -1);
        }

        return res;
    }

    // Take the array and return an array which has double the elements of the
    // original array.
    private int[] expand(int[] nums) {
        int[] res = new int[nums.length * 2];
        for (int i = 0; i < res.length; i++) {
            res[i] = nums[i % nums.length];
        }
        return res;
    }
}
