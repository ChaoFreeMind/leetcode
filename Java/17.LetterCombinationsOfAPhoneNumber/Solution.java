//Backtrackingimport java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
	
	public static void main(String[] args) {
		System.out.println(new Solution().letterCombinations("23"));
	}
	
    public List<String> letterCombinations(String digits) {
    	
    	Map<Integer, String> map = new HashMap<>();
    	initMap(map);
    	List<String> resList = new ArrayList<>();
    	
    	backtrack(resList, digits, 0, new StringBuilder(), map);
    	
    	return resList;   	
    }
    
    private void backtrack(List<String> resList, String digits, int pos, StringBuilder sb, Map<Integer, String> map) {
    	if(pos == digits.length()) {
    		resList.add(sb.toString());
    		return;
    	}
    	Character digit = digits.charAt(pos);
    	if(map.containsKey(digit - '0')) {
    		String value = map.get(digit - '0');
    		for(int i = 0; i < value.length(); i++) {
    			sb.append(value.charAt(i));
    			backtrack(resList, digits, pos + 1, sb, map);
    			sb.deleteCharAt(sb.length() - 1);
    		}
    		
    	}
    }
    
    private void initMap(Map<Integer, String> map) {   	
    	map.put(2, "abc");
    	map.put(3, "def");
    	map.put(4, "ghi");
    	map.put(5, "jkl");
    	map.put(6, "mno");
    	map.put(7, "pqrs");
    	map.put(8, "tuv");
    	map.put(9, "wxyz");
    }
}