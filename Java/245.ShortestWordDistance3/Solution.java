public class Solution {
    // public int shortestWordDistance(String[] words, String word1, String word2) {
    // 	int shortest = Integer.MAX_VALUE;
    // 	int lastSeen1 = -1, lastSeen2 = -1;
    // 	for (int i = 0; i < words.length; i++) {
    // 		if (word1.equals(word2) && words[i].equals(word1)) {
    // 			if (lastSeen1 > lastSeen2) {
    // 				lastSeen2 = i;
    // 				shortest = Math.min(shortest, Math.abs(lastSeen2 - lastSeen1));
    // 			} else if (lastSeen2 >= lastSeen1) {
    // 				lastSeen1 = i;
    // 				if (lastSeen2 != -1) shortest = Math.min(shortest, Math.abs(lastSeen2 - lastSeen1));
    // 			}
    // 		} else if (words[i].equals(word1)){
    // 			lastSeen1 = i;
    // 			if (lastSeen2 != -1) shortest = Math.min(shortest, Math.abs(lastSeen2 - lastSeen1));
    // 		} else if (words[i].equals(word2)) {
    // 			lastSeen2 = i;
    // 			if (lastSeen1 != -1) shortest = Math.min(shortest, Math.abs(lastSeen2 - lastSeen1));
    // 		}
    // 	}

    // 	return shortest;
    // }

    public int shortestWordDistance(String[] words, String word1, String word2) {
    	// Last updated index
    	int idx = -1;
    	int shortest = words.length;

    	for (int i = 0; i < words.length; i++) {
    		if (words[i].equals(word1) || words[i].equals(word2)) {
    			if (word1.equals(word2) || idx != -1 && !words[idx].equals(word[i])) {
    				shortest = Math.min(shortest, i - idx);
    			}
    			idx = i;
    		}
    	}

    	return shortest;
    }
}