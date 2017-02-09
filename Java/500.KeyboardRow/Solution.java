public class Solution {
   
    public String[] findWords(String[] words) {
        String line1 = "qwertyuiop";
        String line2 = "asdfghjkl";
        String line3 = "zxcvbnm";
        
        List<String> resList = new ArrayList<>();

        for (String word: words) {
            String wordLower = word.toLowerCase();
            if (check(wordLower, line1) || check(wordLower, line2) || check(wordLower, line3)) {
                resList.add(word);
            }
        }

        return toArray(new String[resList.size()]);
    }

    /**
     * Check if all characters in word are consist of characters from line
     */
    private boolean check(String word, String line) {

        for (char c: word.toCharArray()) {
            if (line.indexOf(c) == -1) {
                return false;
            }
        }

        return true;
    }
}