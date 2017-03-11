// Write a function to generate the generalized abbreviations of a word.

// Example:
// Given word = "word", return the following list (order does not matter):
// ["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1", "w1r1", "1o2", 
// "2r1", "3d", "w3", "4"]

public class Solution {
    public List<String> generateAbbreviations(String word) {
        List<String> resList = new ArrayList<>();

        StringBuilder abbr = new StringBuilder();
        backtrack(word, resList, abbr, 0, 0);

        return resList;     
    }
    // Pretty slow due to reformatting the result: addUpAbbr.
    // See Improved.java for improvements
    private void backtrack(String word, List<String> resList, StringBuilder abbr, int pos, int abbrCount) {
        if (pos >= word.length()) {
            if (abbrCount > 0) abbr.append(abbrCount);
            resList.add(abbr.toString());
            return ;
        }

        // For each characters in word, we either abbreviate it or we do not.

        // Not abbreviate character at pos
        int len = abbr.length();
        if (abbrCount > 0) abbr.append(abbrCount);
        abbr.append(word.charAt(pos));
        backtrack(word, resList, abbr, pos + 1, 0);
        abbr.setLength(len);

        // Abbreviate
        backtrack(word, resList, abbr, pos + 1, abbrCount + 1);
        abbr.setLength(len);
    }

    private boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }
}