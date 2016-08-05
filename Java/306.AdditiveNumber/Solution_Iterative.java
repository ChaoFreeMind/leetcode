public class Solution {

	public boolean isAdditiveNumber(String num) {
		int len = num.length();
		//i is the length of the first number
		for(int i = 1; i <= len / 2; i++) {
			for(int j = 1; Math.max(i, j) <= len - i - j; j++) {
				if(verify()) return true;
			}
		}
		return false;
	}
	/*
	i: the length of the first number
	j: the length of the second number
	*/
	private boolean verify(String num, int i, int j) {
		if(num.charAt(0) == '0' && i != 1) return false;
		if(num.charAt(i) == '0' && j != 1) return false;
		Long first = Long.parseLong(num.substring(0, i));
		Long second = Long.parseLong(num.substring(i, i + j));
		
		for(int start = i + j; start <= num.length(); start += delta) {
			Long sum = first + second;
			int delta = String.valueOf(sum).length();
			if(!num.startsWith(sum, start)) return false;
			first = second;
			second = sum;
		}
		return true;
	}
}