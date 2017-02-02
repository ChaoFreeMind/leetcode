public class Solution {

	public String convertToTitle(int n) {
		StringBuilder sb = new StringBuilder();
		while (n != 0) {
			char c = 'A' + (n - 1) % 26;
			sb.append(c);
			(n - 1) /= 26;
		}
		return sb.reverse().toString();
	}	

}
