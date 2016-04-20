import java.util.ArrayList;
import java.util.List;

public class Solution {

//	public static void main(String[] args) {
//		System.out.println(new Solution().partition("aab"));
//	}
	
    public List<List<String>> partition(String s) {
    	List<List<String>> resList = new ArrayList<>();
    	List<String> path = new ArrayList<>();
    	backtrack(resList, path, 0, s);
    	return resList;
    }
    
    private void backtrack(List<List<String>> resList, List<String> path, int pos, String s) {
    	
    	if(pos == s.length()) {
    		resList.add(new ArrayList<>(path));
    		return;
    	}
    	
    	for(int i = pos; i < s.length(); i++) {
    		if(isPalindrome(s.substring(pos, i+1))) {
    			path.add(s.substring(pos, i+1));
    			backtrack(resList, path, i+1, s);
    			path.remove(path.size() - 1);
    		}
    	}
    }
    
    private boolean isPalindrome(String s) {
    	int left = 0, right = s.length() - 1;
    	while(left < right) {
    		if(s.charAt(left) != s.charAt(right)) return false;
    		left++;
    		right--;
    	}
    	return true;
    }
}