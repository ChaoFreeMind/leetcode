public class Solution {

    // No magic numbers
    private static final int ASCII_COUNT = 256;

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int[] hash = new int[ASCII_COUNT];
        int left = 0;
        int right = 0;
        int diff = p.length();

        for (int i = 0; i < p.length(); i++) {
            hash[p.charAt(i)]++;
        }

        while (right < s.length()) {

            if (hash[s.charAt(right)] >= 1) {
                diff--;
            }

            hash[s.charAt(right)]--;
            // Expand the window
            right++;

            // If diff is 0, it means the current string [left, right] is a valid anagram
            if (diff == 0) {
                res.add(left);
            }

            if (right - left == p.length()) {

                // If the left character was in the original string p.
                if (hash[s.charAt(left)] >= 0) {
                    diff++;
                }
                hash[s.charAt(left)]++;
                left++;
            }
        }

        return res;
    }
}