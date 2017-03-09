// bit counting: https://tech.liuchao.me/2016/11/count-bits-of-integer/
public class Solution {
    // Naive
    public int hammingDistance(int x, int y) {
        int xor = x ^ y;
        int res = 0;
        while (xor != 0) {
            res += xor & 1;
            xor >>= 1;
        }
        return res;
    }

    // Improved
    public int hammingDistance(int x, int y) {
        int xor = x ^ y;
        return Integer.bitCount(xor);
    }

    public int hammingDistance(int x, int y) {
        int xor = x ^ y;
        return countBits(xor);
    }

    // Return the number of bits of n
    private boolean countBits(int n) {
        int count = 0;
        while (n != 0) {
            // Clear the last one bit.
            n = n & (n - 1);
            count++;
        }
        return count;
    }
}
