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
    /*public boolean isAnagram(String s, String t) {
    	if(s == null || t == null) return false;
    	char[] sarr = s.toCharArray();
    	char[] tarr = t.toCharArray();
    	Arrays.sort(sarr);
    	Arrays.sort(tarr);
    	return new String(sarr).equals(new String(tarr));
    }*/
    
	//If only contains lower-case letters
    public boolean isAnagram(String s, String t) {
    	int[] alphabet = new int[26];
    	for(char c: s.toCharArray()) alphabet[c - 'a']++;
    	for(char c: t.toCharArray()) alphabet[c - 'a']--;
    	for(int i: alphabet) if(i != 0) return false; 
    	return true;
    }
    
}