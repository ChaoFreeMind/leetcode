public class Solution {
    public int lengthOfLastWord(String s) {
    	s = s.trim();
    	if(s.lastIndexOf(' ') == -1) return s.length();
    	return s.length() - 1 - s.lastIndexOf(' ');
    }
}