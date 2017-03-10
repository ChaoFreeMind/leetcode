// Write a program to find the nth super ugly number.

// Super ugly numbers are positive numbers whose all prime factors are in the given prime list 
// primes of size k. For example, [1, 2, 4, 7, 8, 13, 14, 16, 19, 26, 28, 32] is the sequence of the
// first 12 super ugly numbers given primes = [2, 7, 13, 19] of size 4.

// Note:
// (1) 1 is a super ugly number for any given primes.
// (2) The given numbers in primes are in ascending order.
// (3) 0 < k ≤ 100, 0 < n ≤ 106, 0 < primes[i] < 1000.
// (4) The nth super ugly number is guaranteed to fit in a 32-bit signed integer.

public class Solution {
    //Will have to work on this problem again, did not have a clue as I first saw it.
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[1] = 1;

        int[] indexes = new int[primes.length];
        Arrays.fill(indexes, 1);
        // At the beginning all index are starting at 1.

        for (int i = 2; i <= n; i++) {
            
            for (int j = 0; j < primes.length; j++) {
                // indexes[j]: the index of dp which primes[j]
                dp[i] = Math.min(dp[i], primes[j] * dp[indexes[j]]);
            }

            // Deduplicate
            for (int j = 0; j < primes.length; j++) {
                if (dp[indexes[j]] * primes[j] == dp[i]) {
                    indexes[j]++;
                }
            }
        }

        return dp[n];
    }

}