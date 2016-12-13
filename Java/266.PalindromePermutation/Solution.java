public class Solution {
	// Hash map 'c' -> 12
	// Time: O(n) Space: O(n) where n is the number of characters in s
    // public boolean canPermutePalindrome(String s) {
    // 	if (s == null) return true;
    // 	// Declare everything in the beginning
    // 	Map<Character, Integer> charMap = new HashMap<>();
    // 	int even = 0, odd = 0;
    // 	int len = s.length();

    // 	for (char c: s.toCharArray()) {
    // 		Integer oldVal = charMap.get(c);
    // 		Integer newVal = oldVal == null ? 1 : oldVal + 1;
    // 		charMap.put(c, newVal);
    // 	}

    // 	for (Integer value: charMap.values()) {
    // 		if (value % 2 == 0) even++;
    // 		else odd++;
    // 	}

    // 	return (len % 2 == 0 && odd == 0) || (len % 2 != 0 && odd == 1);
    // }

	// A much better alternative
    public boolean canPermutePalindrome(String s) {
    	Set<Character> set = new HashSet<>();
    	for (char c: s.toCharArray()) {
    		if (!set.contains(c)) {
    			set.add(c);
    		} else {
    			set.remove(c);
    		}
    	}
    	return set.size() <= 1;
    }
}