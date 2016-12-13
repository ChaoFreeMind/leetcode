public class Solution {

	// Return the number represented by character c
	private int mapToInt(char c) {
		return (c - 'A' + 1);
	}

    public int titleToNumber(String s) {
    	int res = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
        	char c = s.charAt(i);
        	res += mapToInt(c) * Math.pow(26, s.length() - i - 1);
        }
        return res;
    }
}