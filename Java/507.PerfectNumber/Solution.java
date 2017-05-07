// We define the Perfect Number is a positive integer that is equal to the sum of all its positive 
// divisors except itself.

// Now, given an integer n, write a function that returns true when it is a perfect number and false
// when it is not.
// Example:
// Input: 28
// Output: True
// Explanation: 28 = 1 + 2 + 4 + 7 + 14
// Note: The input number n will not exceed 100,000,000. (1e8)

public class Solution {
    // O(n) time and O(n) space where n is the number of divisors of num
    public boolean checkPerfectNumber(int num) {        
        if (num <= 0) return false;

        int sum = 1;
        Set<Integer> divisorSet = new HashSet<>();

        for (int i = 2; i <= Math.sqrt(num); i++) {
            if ((num % i) == 0) {
                divisorSet.add(i);
                divisorSet.add(num % i);
            }
        }

        for (int d: divisorSet) {
            sum += d;
        }

        return sum == num;
    }
}