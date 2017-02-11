// Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.

// Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.

// The order of output does not matter.

// Example 1:

// Input:
// s: "cbaebabacd" p: "abc"

// Output:
// [0, 6]

// Explanation:
// The substring with start index = 0 is "cba", which is an anagram of "abc".
// The substring with start index = 6 is "bac", which is an anagram of "abc".
// Example 2:

// Input:
// s: "abab" p: "ab"

// Output:
// [0, 1, 2]

// Explanation:
// The substring with start index = 0 is "ab", which is an anagram of "ab".
// The substring with start index = 1 is "ba", which is an anagram of "ab".
// The substring with start index = 2 is "ab", which is an anagram of "ab".
public class Solution {
    // Brute force: barely passed O(n^2)
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int ls = s.length();
        int lp = p.length();
        for (int i = 0; i + lp <= ls; i++) {
            String subStr = s.substring(i, i + lp);
            if (isAnagram(subStr, p)) {
                res.add(i);
            }
        }

        return res;
    }

    // Return if String a is anagram of String b
    private boolean isAnagram(String a, String b) {
        if (a.length() != b.length()) return false;

        int[] alphabet = new int[26];

        for (int i = 0; i < a.length(); i++) {
            alphabet[a.charAt(i) - 'a']++;
        }

        for (int i = 0; i < b.length(); i++) {
            if (--alphabet[b.charAt(i) - 'a'] < 0) return false;
        }

        // for (int i = 0; i < 26; i++) {
        //     if (alphabet[i] != 0) return false;
        // }

        return true;
    }
}