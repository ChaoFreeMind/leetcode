import java.math.BigInteger;

//For this problem, we only need to decide the first and second number that reason being that the third number is the sum of the first 2, fourth is the sum of 2nd and the 3rd, so on and so forth. 
public class Solution {

	//Let i be the length of the first number, j be the length of the second number
	public boolean isAdditiveNumber(String num) {
		
		int len = num.length();
		for(int i = 1; i <= len / 2; i++) {
			
			if(i > 1 && num.charAt(0) == '0') return false;
			
			BigInteger a = new BigInteger(num.substring(0, i));
			
			for(int j = 1; Math.max(i, j) <= len - j - i; j++) {
				
				BigInteger b = new BigInteger(num.substring(i, i+j));
				
				if(j > 1 && num.charAt(i) == '0') break;
				
				if(isValidIter(a, b, num.substring(i+j))) return true;
				
			}
			
		}
		
		return false;
	}
	
	private boolean isValidRecur(BigInteger a, BigInteger b, String rest) {
		
		if(rest.equals("")) return true;
		
		BigInteger c = a.add(b);
		String sum = c.toString();
		
		if(!rest.startsWith(sum)) return false; 
		
		return isValidRecur(b, c, rest.substring(sum.length()));
	}
	
	private boolean isValidIter(BigInteger a, BigInteger b, String rest) {
		return false;
	}
	
	
	
	public static void main(String[] args) {
		
		boolean result = new Solution().isAdditiveNumber("112358");
		
	}
	
}
