public class Solution {
	// Recursion
    public int getSum(int a, int b) {
    	if (b == 0) return a;        
        return getSum(a ^ b, ((a & b) << 1));
    }

    // Iteration
    public int getSum(int a, int b) {
    	int xor = a, carry = b;

    	while (carry != 0) {
    		int temp = xor ^ carry;
    		carry = (xor & carry) << 1;
    		xor = temp;
    	}

    	return xor;
    }
}