public class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
        // keep track of the last appearance of both words.
        int min = Integer.MAX_VALUE;
        int idx1 = -1, idx2 = -1;
        for (int i = 0; i < words.length; i++) {
        	if (words[i].equals(word1)) {
        		idx1 = i;
        		if (idx2 != -1) min = Math.min(min, Math.abs(idx1 - idx2));
        	} else if (words[i].equals(word2)) {
        		idx2 = i;
        		if (idx1 != -1) min = Math.min(min, Math.abs(idx1 - idx2));
        	}
        }
        return min;
    }
}