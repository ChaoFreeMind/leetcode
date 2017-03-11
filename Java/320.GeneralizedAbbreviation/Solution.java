// Write a function to generate the generalized abbreviations of a word.

// Example:
// Given word = "word", return the following list (order does not matter):
// ["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1", "w1r1", "1o2", 
// "2r1", "3d", "w3", "4"]

public class Solution {
    public List<String> generateAbbreviations(String word) {
        List<String> resList = new ArrayList<>();

        StringBuilder abbr = new StringBuilder();
        backtrack(word, resList, abbr, 0);

        return resList;     
    }
    // Pretty slow due to reformatting the result: addUpAbbr.
    // See Improved.java for improvements
    private void backtrack(String word, List<String> resList, StringBuilder abbr, int pos) {
        if (pos >= word.length()) {
            // Add up those 1s in abbr
            resList.add(addUpAbbr(abbr));
            return ;
        }

        // For each characters in word, we either abbreviate it or we do not.

        // Not abbreviate character at pos
        abbr.append(word.charAt(pos));
        backtrack(word, resList, abbr, pos + 1);
        abbr.deleteCharAt(abbr.length() - 1);

        // Abbreviate
        abbr.append(1);
        backtrack(word, resList, abbr, pos + 1);
        abbr.deleteCharAt(abbr.length() - 1);
    }

    private String addUpAbbr(StringBuilder abbr) {
        StringBuilder res = new StringBuilder();
        int abbrCount = 0;
        for (int i = 0; i < abbr.length(); i++) {
            char c = abbr.charAt(i);
            if (isDigit(c)) {
                abbrCount++;
            } else {
                if (abbrCount != 0) res.append(String.valueOf(abbrCount));
                res.append(c);
                abbrCount = 0;
            }
        } 
        if (abbrCount != 0) res.append(String.valueOf(abbrCount));
        return res.toString();
    }

    private boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }
}