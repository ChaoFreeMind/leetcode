public class Solution {
     public int divide(int dividend, int divisor) {
     	if(divisor == 0) return Integer.MAX_VALUE; 
    	boolean isNegative = (dividend < 0) ^ (divisor < 0);
    	long ldvd = Math.abs((long)dividend);
    	long ldvs = Math.abs((long)divisor);
    	
    	long res = 0;
    	while(ldvs <= ldvd) {
    		long temp = ldvs, multi = 1;
    		while((temp << 1) <= ldvd) {
    			temp <<= 1;
    			multi <<= 1;
    		}
    		ldvd -= temp;
    		res += multi;
    	}
    	
    	res = isNegative ? -res: res;
    	
    	return (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) ? Integer.MAX_VALUE : (int)res; 
    }
}