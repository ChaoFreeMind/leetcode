// There is a fence with n posts, each post can be painted with one of the k colors.

// You have to paint all the posts such that no more than two adjacent fence posts have the same color.

// Return the total number of ways you can paint the fence.

// Note:
// n and k are non-negative integers.
public class Solution {
    public int numWays(int n, int k) {
        if (n == 0 || k == 0) return 0;
        if (n == 1) return k;
        // Number of ways to paint if the current post has the differenct / same color as the 
        // prevous one.
        int diff = k, same = 0;

        for (int i = 1; i < n; i++) {
            int curDiff = same * (k - 1) + diff * (k - 1);
            same = diff;
            diff = curDiff;
        }

        return diff + same;
    }
}