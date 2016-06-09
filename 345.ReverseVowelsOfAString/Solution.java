// Write a function that takes a string as input and reverse only the vowels of a string.

// Example 1:
// Given s = "hello", return "holle".

// Example 2:
// Given s = "leetcode", return "leotcede".
public class Solution {
    public String reverseVowels(String s) {
    	if(s == null || s.length() == 0) return s;
        int left = 0, right = s.length() - 1;
        // char[] carr = s.toLowerCase().toCharArray(); cases matter!!
        char[] carr = s.toCharArray();
        while(left < right) {
        	if(isVowel(carr[left]) && isVowel(carr[right])) {
        		char temp = carr[left];
        		carr[left] = carr[right];
        		carr[right] = temp;
        		left++;
        		right--;
        	} else if(!isVowel(carr[left])) {
        		left++;
        	} else if(!isVowel(carr[right])) {
        		right--;
        	}
        }

        return new String(carr);
    }

    //tip: java indexOf(c) returns -1 if not found.
    private boolean isVowel(char c) {
    	return "aeiouAEIOU".indexOf(c);
    }
}