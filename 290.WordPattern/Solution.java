public class Solution {
    public boolean wordPattern(String pattern, String str) {
    	
    	//First make sure the num of letters in pattern and the number of words in str are the same.
    	String[] words = str.trim().split(" ");
    	if(words.length != pattern.length()) return false;
    	Map<Character, String> map = new HashMap<>();
    	int len = pattern.length();
    	for(int i = 0; i < len; i++) {
    		char c = pattern.charAt(i);
    		if(!map.containsKey(c)) {
    			if(map.containsValue(words[i])) return false;
    			map.put(c, words[i]);
    		} else {
    			if(!map.get(c).equals(words[i])) return false;
    		}
    	}
    	
    	return true;
    }
}