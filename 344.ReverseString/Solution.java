// Write a function that takes a string as input and returns the string reversed.

// Example:
// Given s = "hello", return "olleh".
public class Solution {
	/*public String reverseString(String s) {
		StringBuilder sb = new StringBuilder();

		for(int i = 0; i < s.length(); i++) {
			sb.insert(0, s.charAt(i));
		}

		return sb.toString();
	}*/

	//2 pointers
	public String reverseString(String s) {
		if(s == null || s.length() == 0) return s;
		char[] carr = s.toCharArray();
		int left = 0, right = carr.length - 1;
		while(left < right) {
			char temp = carr[left];
			carr[left] = carr[right];
			carr[right] = temp;
			left++;
			right--;
		}

		return new String(carr);
	}
}