public class Solution {
	//Recursive
	public boolean isAdditiveNumber(String num) {
		int len = num.length();
		//Let the length of the first number and second number be i and j
		for(int i = 1; i <= len / 2; i++) {
			if(num.charAt(0) == '0' && i != 1) return false;
			for(int j = 1; Math.max(i, j) <= len - i - j; j++) {
				if(num.charAt(i) == '0' && j != 1) break;
				Long a = Long.parseLong(num.substring(0, i));
				Long b = Long.parseLong(num.substring(i, i + j));
				if(isValid(num, i + j, a, b)) return true;
			}
		}
		return false;
	}

	private boolean isValid(String num, int start, Long a, Long b) {
	    if(start == num.length()) return true;
		Long c = a + b;
		//Automatically deal with leading 0s!
		int sumLen = c.toString().length();
		return num.substring(start).startsWith(c.toString()) && isValid(num, start + sumLen, b, c);
	}

}