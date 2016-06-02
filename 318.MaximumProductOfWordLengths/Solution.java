public class Solution {
    //TLE
    /*public int maxProduct(String[] words) {
    	int max = 0;
    	for(int i = 0; i < words.length; i++) {
    		for(int j = i + 1; j < words.length; j++) {
    			if(!hasCommonLetters(words[i], words[j])) {
    				max = Math.max(max, words[i].length * words[j].length);
    			}
    		}
    	}
    	return max;
    }

    private boolean hasCommonLetters(String s1, String s2) {
    	Set<Character> intersection = new HashSet<>();
    	for(char c: s1.toCharArray()) {
    		intersection.add(c);
    	}
    	for(char c: s2.toCharArray()) {
    		if(intersection.contains(c)) return true;
    	}
    	return false;
    }*/

    //The key of this problem is that how to quickly find out if 2 strings contain the same character.
    //One int has 32 bits, it is enough to work as a mask to specify if a letter exists in the string.
    //O(n) space O(n*n) time
    public int maxProduct(String[] words) {
    	if(words == null || words.length == 0) return 0;
    	int n = words.length;
    	int[] mask = new int[n];
    	for(int i = 0; i < n; i++) {
    		String word = words[i];
    		for(int j = 0; j < word.length(); j++) {
    			value[i] |= 1 << (word.charAt(j) - 'a')
    		}
    	}
    	int max = 0;
    	for(int i = 0; i < n; i++) {
    		for(int j = i + 1; j < n; j++) {
    			if(value[i] & value[j] == 0) {
    				max = Math.max(max, words[i].length * words[j].length);
    			}
    		}
    	}

    	return max;
    }
}