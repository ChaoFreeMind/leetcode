public class Solution {
	private int low;
	private int maxLen;
	
    public String longestPalindrome(String s) {
    	
    	for(int i = 0; i < s.length(); i++) {
    		
    		extendPalindrome(s, i, i);
    		extendPalindrome(s, i, i+1);
    		
    	}
    	
    	return s.substring(low, low + maxLen);
    }
    
    private void extendPalindrome(String s, int left, int right) {
    	
    	while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
    			left--;
    			right++;
    	}
    	if(this.maxLen < right - left - 1) {
    		this.low = left + 1;
    		this.maxLen = right- left - 1;
    	}
    }
}