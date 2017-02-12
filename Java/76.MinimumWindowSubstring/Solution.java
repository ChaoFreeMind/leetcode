// Basic template of sliding window problem: 
// https://discuss.leetcode.com/topic/30941/here-is-a-10-line-template-that-can-solve-most-substring-problems
public class Solution {

    private static final int ASCII_COUNT = 256;

    public String minWindow(String s, String t) {
        if (s.length() == 0 || t.length() == 0) {
            return "";
        }
        int[] hash = new int[ASCII_COUNT];
        int left = 0;
        int right = 0;
        int diff = t.length();
        int startIdx = 0;
        int minLen = Integer.MAX_VALUE;

        for (int i = 0; i < t.length(); i++) {
            hash[t.charAt(i)]++;
        }

        while (right < s.length()) {
            // First find the first character in s that is also in t
            if (hash[s.charAt(right)] >= 1) {
                diff--;
            }
            hash[s.charAt(right)]--;
            right++;

            while (diff == 0) {
                // If current left is originally in s, it means we have found a valid window
                if (hash[s.charAt(left)] >= 0) {
                    diff++;
                    //At this point we have found a local min window
                    if (right - left < minLen) {
                        minLen = right - left;
                        startIdx = left;
                    }

                }

                hash[s.charAt(left)]++;
                left++;
            }

        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(startIdx, startIdx + minLen);
    }
}