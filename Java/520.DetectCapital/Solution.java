// Given a word, you need to judge whether the usage of capitals in it is right or not.

// We define the usage of capitals in a word to be right when one of the following cases holds:

// All letters in this word are capitals, like "USA".
// All letters in this word are not capitals, like "leetcode".
// Only the first letter in this word is capital if it has more than one letter, like "Google".
// Otherwise, we define that this word doesn't use capitals in a right way.
// Example 1:
// Input: "USA"
// Output: True
// Example 2:
// Input: "FlaG"
// Output: False
// Note: The input will be a non-empty word consisting of uppercase and lowercase latin letters.

public class Solution {

    public boolean detectCapitalUse(String word) {
        if (word.length() == 1) return true;
        boolean result = true;
        char first = word.charAt(0);
        String substr = word.substring(1, word.length());

        if (isUpper(first)) {
            result = isAllLowerOrUpper(substr);
        } else {
            // all lowercase
            result = !isUpper(word.charAt(1)) && isAllLowerOrUpper(substr);
        }

        return result;        
    }

    // Return true if all characters in word are lowercase or uppercase
    private boolean isAllLowerOrUpper(String word) {

        boolean upper = isUpper(word.charAt(0));

        for (char c: word.toCharArray()) {
            if (isUpper(c) != upper) {
                return false;
            }
        }

        return true;
    }
    
    private boolean isUpper(char c) {
        return c >= 'A' && c <= 'Z';
    }

}