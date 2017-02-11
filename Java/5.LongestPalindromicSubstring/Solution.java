public class Solution {

    // Method 1: Dynamic Programming: O(n^2) time and O(n^2) space
    // Let's see how we can improve based on the brute force method.
    // One common way I can think of is to build new palindrome based on previous results
    // We can achieve this by dynamic programming: say dp[i][j] denotes if substring(i, j) 
    // is a palindrome or not. If it is then dp[i - 1][j + 1] is also palindrome if dp[i][j] == true
    // and s.charAt(i-1) == s.charAt(j + 1)
    public String longestPalindrome(String s) {

        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        // Since the complexity of substring() is O(n), it is better to keep track of 
        // the max palindrome by its starting index and its length.
        int startIdx = 0;
        int maxLen = 0;

        // Only doing this backwards can we build current result based on previous results
        // i is the starting index and j is the end
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i; j < len; j++) {
                // Think carefully: 
                // Why j - i < 3? 1) j == i: a 2) j - i == 1: aa 3) j - i == 2: aba
                if (s.charAt(i) == s.charAt(j) && (j - i < 3 || dp[i + 1][j - 1])) {
                    dp[i][j] = true;
                    // compute length
                    int newLen = j - i + 1;
                    if (maxLen < newLen) {
                        startIdx = i;
                        maxLen = newLen;
                    }
                }
            }
        }

        return s.substring(startIdx, startIdx + newLen);
    }

    // Method 2: Expand from the center O(n^2) time and O(1) space
    // The basic idea is to take one character or two characters as base string, expand two characters 
    // at a time from its left and right until it can not form a palindrome.
    // O(n^2)
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

        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        // Return the previous valid palindrome substring
        return s.substring(left - 1, right);
    }
}