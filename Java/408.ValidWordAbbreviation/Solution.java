// Given a non-empty string s and an abbreviation abbr, return whether the string matches with the 
// given abbreviation.

// A string such as "word" contains only the following valid abbreviations:

// ["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1", "w1r1", "1o2", 
// "2r1", "3d", "w3", "4"]
// Notice that only the above abbreviations are valid abbreviations of the string "word". Any other 
// string is not a valid abbreviation of "word".

// Note:
// Assume s contains only lowercase letters and abbr contains only lowercase letters and digits.

// Example 1:
// Given s = "internationalization", abbr = "i12iz4n":

// Return true.
// Example 2:
// Given s = "apple", abbr = "a2e":

// Return false.
public class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {

        if (abbr == null || abbr.length() == 0) return false;
        
        int i = 0, j = 0;

        while (i < word.length() && j < abbr.length()) {
            
            char cw = word.charAt(i), ca = abbr.charAt(j);

            if (cw == ca) {
                i++;
                j++;
            } else if (isDigit(ca)){
                int digitStart = j;
                // Extract the consecutive digits to a number
                while (j < abbr.length() && isDigit(abbr.charAt(j))) j++;
                String sNum = abbr.substring(digitStart, j);
                // Check leading zeros
                if (sNum.startsWith("0")) {
                    return false;
                }

                int num = Integer.parseInt(sNum);
                // Move the cursor of i
                i += num;
            } else {
                return false;
            }
        }

        return i == word.length() && j == abbr.length();
    }

    // Check if char is a digit character
    private boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }

    // This problem can be solved using regex, damn good!
    public boolean validWordAbbreviation(String word, String abbr) {
        return word.matches(abbr.replaceAll("[1-9]\\d*", ".{$0}"));
    }
}

