import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 2. Permutate and deduplication.
// 3. Transform into palindrome.

public class Solution {
	
	public static void main(String[] args) {
		List<String> list = new Solution().generatePalindromes("aabbcc");
	
	}
	
    public List<String> generatePalindromes(String s) {
	    	List<String> resList = new ArrayList<>();
	    	Map<Character, Integer> countMap = new HashMap<>();
	    	List<Character> charList = new ArrayList<>();
	    	// Set<String> permSet = new HashSet<>();
	    	int oddCount = 0;
	    	String mid = "";
	
			// 1. Find out all unique characters that could form a palindrome.
	    	for (int i = 0; i < s.length(); i++) {
	    		char c = s.charAt(i);
	    		int newCount = countMap.getOrDefault(c, 0) + 1;
	    		if (newCount % 2 == 0) oddCount--;
	    		else oddCount++;
	    		countMap.put(c, newCount);
	    	}
	
	    	if (oddCount > 1) return resList;
	
	    	for (Map.Entry<Character, Integer> entry: countMap.entrySet()) {
	    		char key = entry.getKey();
	    		int val = entry.getValue();
	    		if (val % 2 != 0) mid += key;
	    		for (int i = 0; i < val / 2; i++) charList.add(key);
	    	}
	System.out.println(charList);
	    	// 2. Permutate and generate palindromes
	    	genPerm(charList, mid, new boolean[charList.size()], new StringBuilder(), resList);
	
	    	return resList;
    }

    private void genPerm(List<Character> charList, String mid, boolean[] visited, StringBuilder sb, List<String> resList) {
	    	if (sb.length() == charList.size()) {
	    		resList.add(sb.toString() + mid + sb.reverse().toString());
	    		// Do not forget to reverse sb back cuz it is shared!!
	    		sb.reverse();
	    		return;
	    	}
	
	    	for (int i = 0; i < charList.size(); i++) {
	
	    		if (i > 0 && charList.get(i) == charList.get(i-1) && !visited[i-1]) continue;
	
	    		if (!visited[i]) {
	    			visited[i] = true;
	    			sb.append(charList.get(i)); 
	    			genPerm(charList, mid, visited, sb, resList);
	    			visited[i] = false;
	    			sb.deleteCharAt(sb.length() - 1);
	    		}
	    	}
    }

}