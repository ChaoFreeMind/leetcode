public class Solution {

    public boolean repeatedSubstringPattern(String str) {
    	int len = str.length();
    	
    	
    	for (int i = 1; i <= len / 2; i++) {
    		if (len % i != 0) continue;
    		String repeatStr = str.substring(0, i);
    		int j = i;
            boolean result = true;
    		while (j != len) {
    			if (!str.startsWith(repeatStr, j)) {
    				result = false;
    				break;
    			}
    			j += i;
    		}
    		if (result) return true;
    	}

    	return false;
    }

    // Cleaner but slower way
    public boolean repeatedSubstringPattern(String str) {
    	int len = str.length();
    	for (int i = 1; i <= len / 2; i++) {
    		if (len % i != 0) continue;
    		String repeatStr = str.substring(0, i);
    		StringBuilder sb = new StringBuilder();
    		for (int j = 0; j < len / i; j++) {
    			sb.append(repeatStr);
    		}
    		if (sb.toString().equals(str)) return true;
    	}
    	return false;
    }

    // Return earlier
    public boolean repeatedSubstringPattern(String str) {

    }
}