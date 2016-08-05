public class Solution {
	//The idea is very simple:
	//last bit of (odd number & even number) is 0.
	//when m != n, There is at least an odd number and an even number, so the last bit position result is 0.
	//Move m and n rigth a position.
	//Keep doing step 1,2,3 until m equal to n, use a factor to record the iteration time.
    public int rangeBitwiseAnd(int m, int n) {
    	int count = 0;
    	while(m != n) {
    		count++;
    		m >>= 1;
    		n >>= 1;
    	}
    	return m << count;
    }
    
}