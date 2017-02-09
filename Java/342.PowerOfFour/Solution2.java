// Given an integer (signed 32 bits), write a function to check whether it is a power of 4.

// Example:
// Given num = 16, return true. Given num = 5, return false.

// Follow up: Could you solve it without loops/recursion?
<<<<<<< HEAD

public class Solution {

	// Naive
    public boolean isPowerOfFour(int num) {
        if (num <= 0) return false;

        while (num != 1) {
=======
public class Solution {
	// Naive
    public boolean isPowerOfFour(int num) {
        while (num != 4) {
>>>>>>> 07a0ebda1694fa91b9c774ce403044008a8c9d75
        	if (num % 4 != 0) return false;
        	num /= 4;
        }

        return true;
    }
<<<<<<< HEAD

    // Bit manipulation
    public boolean isPowerOfFour(int num) {
    	if (num <= 0) return false;
    	// Only power of 2 and power of 4 would go through
    	if ((num & num - 1) != 0) return false;
    	// Filter out power of 2
    	return (num - 1) % 3 == 0; 
    }
=======
>>>>>>> 07a0ebda1694fa91b9c774ce403044008a8c9d75
}