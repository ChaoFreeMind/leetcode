public class Solution {

	// O(n) space, O(nlgn) time bounded by sorting 
    // public char findTheDifference(String s, String t) {
    // 	char[] arrS = s.toCharArray(), arrT = t.toCharArray();
    // 	Character c = null;
    // 	Arrays.sort(arrS);
    // 	Arrays.sort(arrT);
    // 	for (int i = 0; i < s.length(); i++) {
    // 		if (arrS[i] != arrT[i]) {
    // 			c = arrT[i]; 
    // 			break;
    // 		}
    // 	}
    // 	if (c == null) c = arrT[t.length() - 1];
    // 	return c;
    // }

	// Same as looking for the different integer in an array of integers
	// Time: O(n) Space: O(n)
	// public char findTheDifference(String s, String t) {
	// 	Set<Character> set = new HashSet<>();
	// 	for (int i = 0; i < s.length(); i++) {
	// 		char cs = s.charAt(i);
	// 		char ct = t.charAt(i);
	// 		if (!set.add(cs)) {
	// 			set.remove(cs);
	// 		}

	// 		if (!set.add(ct)) {
	// 			set.remove(ct);
	// 		}
	// 	}
	// 	// Last character of t
	// 	char last = t.charAt(t.length() - 1);
	// 	if (!set.add(last)) set.remove(last);
	// 	Iterator<Character> iter = set.iterator();
	// 	return iter.next();
	// }    
	// XOr trick
	public char findTheDifference(String s, String t) {
		char c = 0;
		int len = s.length();
		for (int i = 0; i < len; i++) {
			c ^= s.charAt(i) ^ t.charAt(i);
		}
		c ^= t.charAt(len);
		return c;
	}
}