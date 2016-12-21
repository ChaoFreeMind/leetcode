public class Solution {

    public int longestPalindrome(String s) {
		Map<Character, Integer> map = new HashMap<>();
		int longest = 0, oddCount = 0;

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			map.put(c, map.getOrDefault(c, 0) + 1);
		}

		for (int val: map.values()) {
			if (val % 2 != 0) oddCount++;
		}

		return oddCount <= 1 ? s.length() : s.length() - oddCount + 1;
    }

    // An easier approach: Count the number of odd-character.
    public int longestPalindrome(String s) {
    	Set<Character> set = new HashSet<>();
    	int len = s.length(), odd = 0;
    	for (int i = 0; i < len; i++) {
    		char c = s.charAt(i);
    		if (set.contains(c)) {
    			set.remove(c);
    		} else {
    			set.add(c);
    			odd++;
    		}
    	}
    	return odd == 0 ? s.length() : s.length() - odd + 1;
    }
}