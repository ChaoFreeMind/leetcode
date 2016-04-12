public class Solution {
	
	public static void main(String[] args) {
		new Solution().myPow(8.88023, 3);
	}
	
    /*public double myPow(double x, int n) {
    	if(n < 0) {
    		x = 1 / x;
    		n = -n;
    	}   	
    	//Base cases
    	if(n == 0) return 1;
    	if(n == 1) return x;
    	if(n == 2) return x * x;
    	if(n % 2 == 0) {
    		return myPow(myPow(x, n / 2), 2);
    	} else {
    		return x * myPow(myPow(x, n / 2), 2);
    	}
    	
    }*/
    
	public double myPow(double x, int n) {
		if(n == 0) return 1;
		if(n < 0) {
			n = -n;
			x = 1 / x;
		}
		//x^2 == x * x ^ n / 2
		
		return n % 2 == 0 ? myPow(x * x, n / 2) : myPow(x * x, n / 2) * x;
	}
    
}