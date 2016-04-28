public class Solution {
	//I would prefer to call it regular way..
    /*public boolean isPowerOfTwo(int n) {
    	while(n != 0) {
    		if((n & 1) == 1 && (n >>> 1) == 0) {
    			return true;
    		}
    		n >>>= 1;//Use unsigned right shift to prevent overflow
    	}
    	
    	
    	return false;
    }*/
    
    //Clever way (n & n - 1) == 0 or Integer.bitCount(n) == 1
    public boolean isPowerOfTwo(int n) {
    	return n > 0 && (n & n - 1) == 0;
    }
}