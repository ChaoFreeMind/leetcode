// Given a List of words, return the words that can be typed using letters of alphabet on only one row's of American keyboard like the image below.


// American keyboard

// Example 1:
// Input: ["Hello", "Alaska", "Dad", "Peace"]
// Output: ["Alaska", "Dad"]
// Note:
// You may use one character in the keyboard more than once.
// You may assume the input string will only contain letters of alphabet.

public class Solution {

    public String[] findWords(String[] words) {
        String row1 = "qwertyuiop";
        String row2 = "asdfghjkl";
        String row3 = "zxcvbnm";
        List<String> resList = new ArrayList<>();
        for (String word: words) {
            word = word.toLowerCase();
            int inRow1 = 1, inRow2 = 1, inRow3 = 1;
            for (char c: word.toCharArray()) {
                if (row1.indexOf(c) < 0) inRow1 = 0;
                if (row2.indexOf(c) < 0) inRow2 = 0;
                if (row3.indexOf(c) < 0) inRow3 = 0;
            }
            if (inRow1 + inRow2 + inRow3 == 1) resList.add(word);
        }

        resList.toArray(new String[resList.size()]);
    }

}