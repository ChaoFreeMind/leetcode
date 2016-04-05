public class Solution {
	
	public boolean isPalindrome(int x) {	
		if(x < 0 || (x != 0 && x % 10 == 0)) return false;
		
		int right = 0;
		while(x > right) {
			right = right * 10 + x % 10;
			x /= 10;
		}
		
		return right == x && right / 10 == x; 
	}
	
	// Reverse the number and compare it to the original one
	// public boolean isPalindrome(int x) {
	// if(x < 0) return false;
	// int num = x;
	// long sum = 0;
	//
	// while(x != 0) {
	// sum = (sum * 10 + x % 10);
	// x /= 10;
	// }
	//
	// return sum == num;
	// }

}