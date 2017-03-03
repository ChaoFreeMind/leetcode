// Suppose you have N integers from 1 to N. We define a beautiful arrangement 
// as an array that is constructed by these N numbers successfully if one of 
// the following is true for the ith position (1 ≤ i ≤ N) in this array:

// The number at the ith position is divisible by i.
// i is divisible by the number at the ith position.
// Now given N, how many beautiful arrangements can you construct?

// Example 1:
// Input: 2
// Output: 2
// Explanation: 

// The first beautiful arrangement is [1, 2]:

// Number at the 1st position (i=1) is 1, and 1 is divisible by i (i=1).

// Number at the 2nd position (i=2) is 2, and 2 is divisible by i (i=2).

// The second beautiful arrangement is [2, 1]:

// Number at the 1st position (i=1) is 2, and 2 is divisible by i (i=1).

// Number at the 2nd position (i=2) is 1, and i (i=2) is divisible by 1.
// Note:
// N is a positive integer and will not exceed 15.
public class Solution {

    private int counter = 0;

    public int countArrangement(int N) {
        // We allocate 1 more space to be able to use 1-based index
        boolean[] used = new boolean[N + 1];
        backtrack(N, 1, used);
        return counter;
    }

    private void backtrack(int N, int curPos, boolean[] used) {
        // curPos > N means the current position has reached the end without 
        // breaking the rule.
        if (curPos > N) {
            counter++;
            return;
        }

        // Now the cursor is at curPos, we need to try out all numbers from 
        // 1 to N, for those that satifies the rule, we move the cursor to the 
        // right until the cursor reaches the end.
        for (int i = 1; i <= N; i++) {
            if (!used[i] && (curPos % i == 0 || i % curPos == 0)) {
                used[i] = true;
                // Go to next recursion
                backtrack(N, curPos + 1, used);
                used[i] = false;
            }
        }
    }
}