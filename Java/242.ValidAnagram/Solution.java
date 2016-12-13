import java.util.Arrays;

public class Solution {
	//In java you can have char c = '\\uXXXX'
	//\\uXXXX (X represents a hex digit)
	public static void main(String[] args) {
		String s = "\uABBC\u00F6\u8921";
		String t = "\u00F6\uABBC\u8921";
		System.out.println(new Solution().isAnagram(s, t));
	}
	
    // a word, phrase, or name formed by rearranging the letters of another, such as cinema, formed from iceman.
	//This solution works even if there is unicode in string
    // public boolean isAnagram(String s, String t) {
    // 	if(s == null || t == null) return false;
    // 	char[] sarr = s.toCharArray();
    // 	char[] tarr = t.toCharArray();
    // 	Arrays.sort(sarr);
    // 	Arrays.sort(tarr);
    // 	// return new String(sarr).equals(new String(tarr));
    //     return Arrays.equals(sarr, tarr);
    // }
    
	//If only contains lower-case letters
    public boolean isAnagram(String s, String t) {
        // Check s and t
        if (s == null) return (t == null);
        if (t == null || s.length() != t.length()) return false;

    	int[] alphabet = new int[26];
    	for(char c: s.toCharArray()) alphabet[c - 'a']++;
    	for(char c: t.toCharArray()) alphabet[c - 'a']--;
    	for(int i: alphabet) if(i != 0) return false; 
    	return true;
    }

    // To handle unicode, use hashmap.
    public boolean isAnagram(String s, String t) {
        if (s == null && t == null) return true; 
        if (s == null && t != null || s != null && t == null) return false;
        
        // At this point we are certain that s and t are both not null
        Map<Character, Integer> charFreqMap = new HashMap<>();
        for (char c: s.toCharArray()) {
            if (charFreqMap.containsKey(c)) {
                charFreqMap.put(c, charFreqMap.get(c) + 1);
            } else {
                charFreqMap.put(c, 1);
            }
        }

        for (char c: t.toCharArray()) {
            if (charFreqMap.containsKey(c)) charFreqMap.put(c, charFreqMap.get(c) - 1);
            else return false;
        }

        for (Map.Entry<Character, Integer> entry: charFreqMap.entrySet()) {
            if (entry.getValue() != 0) return false; 
        }
        return true;

    }
}