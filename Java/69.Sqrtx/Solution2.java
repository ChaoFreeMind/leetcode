// Straightforward: Starting from 1 compute square of current
// number until the product is larger than x
public class Solution {
    // Return MIN Integer if x is negative
    // Be careful for int overflow!!!
    public int mySqrt(int x) {
        if (x == 0) return 0;
        if (x < 0) return Integer.MIN_VALUE;
        int res = 0;
        while (i * i <= x) {
            res = i * i;
        }
        return res;
    }

    // Binary search
    public int mySqrt(int x) {
        if (x == 0) return 0;
        if (x < 0) return Integer.MIN_VALUE;
        int left = 1, right = x;
        int res = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mid < x / mid) {
                left = mid + 1;
                res = mid;
            } else if (mid == x / mid) {
                return mid;
            } else {
                right = mid - 1;
            }
        }

        return res;
    }
}