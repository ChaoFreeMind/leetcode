public class Solution {

    // The basic idea is to take one character or two characters as base string, expand two characters 
    // at a time from its left and right until it can not form a palindrome.
    public String longestPalindrome(String s) {
        
        String res = "";
        
        for (int i = 0; i < s.length(); i++) {
            String s1 = expand(s, i, i);
            String s2 = expand(s, i, i + 1);
            res = res.length() < s1.length() ? s1: res;
            res = res.length() < s2.length() ? s2: res;
        }

        return res;
    }

    private String expand(String s, int left, int right) {
        String res = "";

        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            res = s.substring(left, right + 1);
            left--;
            right++;
        }

        return res;
    }

}