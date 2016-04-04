import java.util.HashMap;
import java.util.Map;

public class Solution {
	//Took a lot of debug! Be ware of abba, when we reach the second a, we have start = 2, end = 3 we dont jump back before start.
	//For abcae, when we reach the second 'a', we need to move start to lastSeen + 1
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> dict = new HashMap<>();//Last-seen dict
        
        int start = 0;
        int max = 0;
        int end = 0;
        
        while (start < s.length() && end < s.length()) {	
        	char c = s.charAt(end);
        	
        	if(dict.containsKey(c)) {
        		//If c has been seen already, get the last index seen, set start to the lastIndex + 1
        		int lastSeen = dict.get(c);
        		if(lastSeen >= start) start = dict.get(c) + 1;
        	}
        	
        	dict.put(c, end);
        	
        	max = Math.max(max, end - start + 1);
        	
        	end++;
        }
        
        return max;
    }
}