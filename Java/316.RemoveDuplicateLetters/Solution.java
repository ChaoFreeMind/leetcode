// Given a string which contains only lowercase letters, remove duplicate letters so that every 
// letter appear once and only once. You must make sure your result is the smallest in 
// lexicographical order among all possible results.

// Example:
// Given "bcabc"
// Return "abc"

// Given "cbacdcbc"
// Return "acdb"


public class Solution {

    public String removeDuplicateLetters(String s) {

        StringBuilder sb = new StringBuilder();

        if (s.length() == 1) return s;

        char[] carr = s.toCharArray();

        Arrays.sort(carr);

        for (int i = 0; i < carr.length - 1; i++) {
            if (carr[i] != carr[i+1]) {
                sb.append(carr[i]);
            }
        }

        return sb.toString();
    }

}