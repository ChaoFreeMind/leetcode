public class Solution {
	//Revised: Reuse digits array 
	public int[] plusOne(int[] digits) {
		if(digits == null || digits.length == 0) return null;
		int n = digits.length;
		for(int i = n - 1; i >= 0; i--) {
			if(digits[i] < 9) {
				digits[i]++;
				return digits;
			} else {
				digits[i] = 0;
			}
		}
		
		int[] res = new int[n+1];
		res[0] = 1;
		return res;
	}
	
	//Beat 4%...
    /*public int[] plusOne(int[] digits) {
        if(digits == null || digits.length == 0) return null;
        int len = digits.length;
        digits[len - 1]++;
        int carry = digits[len - 1] / 10;
        digits[len-1] = digits[len-1] % 10;
        
        for(int i = digits.length - 2; i >= 0 && carry > 0; i--) {
        	digits[i] += carry;
    		carry = digits[i] / 10;
        	digits[i] %= 10;
        }
        
        int[] res = null;
        if(carry > 0) {
        	res = new int[len+1];
        	res[0] = 1;
        	System.arraycopy(digits, 0, res, 1, len);
        } else {
        	res = new int[len];
        	System.arraycopy(digits, 0, res, 0, len);
        	
        }
        return res;
    }*/
}