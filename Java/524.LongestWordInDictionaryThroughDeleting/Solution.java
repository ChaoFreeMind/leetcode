// Given a string and a string dictionary, find the longest string in the 
// dictionary that can be formed by deleting some characters of the given 
// string. If there are more than one possible results, return the longest word 
// with the smallest lexicographical order. If there is no possible result, 
// return the empty string.

// Example 1:
// Input:
// s = "abpcplea", d = ["ale","apple","monkey","plea"]

// Output: 
// "apple"
// Example 2:
// Input:
// s = "abpcplea", d = ["a","b","c"]

// Output: 
// "a"
// Note:
// All the strings in the input will only contain lower-case letters.
// The size of the dictionary won't exceed 1,000.
// The length of all the strings in the input won't exceed 1,000.

public class Solution {

    public String findLongestWord(String s, List<String> d) {

        // Sort by length first, if two strings have equal length, return the 
        // longer one
        Collections.sort(d, (String s1, String s2) -> {
            if (s1.length() == s2.length()) {
                return s1.compareTo(s2);
            }
            return s2.length() - s1.length();
        });

        for (String word: d) {
            // If every characters in word could be found s while maintaining 
            // their sequence, it is the answer(thanks to the way we sort 
            // our array).
            int i = 0, j = 0;
            while (i < word.length() && j < s.length()) {
                if (word.charAt(i) == s.charAt(j)) {
                    i++;
                    j++;
                } else {
                    j++;
                }
            }

            if (j < s.length() || i >= word.length() && j >= s.length()) {
                return word;
            }
        }

        return "";
        
    }

}