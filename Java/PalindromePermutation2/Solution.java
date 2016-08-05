import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

//Given a string s, return all the palindromic permutations (without duplicates) of it. 
//Return an empty list if no palindromic permutation could be form.
//
//For example:
//
//Given s = "aabb", return ["abba", "baab"].
//
//Given s = "abc", return []
public class Solution {
	
	public static void main(String[] args) {
		
		System.out.println(new Solution().generatePalindromes("aabb"));
		
	}
	
	public List<String> generatePalindromes(String s) {
		Map<Character, Integer> map = new HashMap<>();
		List<String> resList = new ArrayList<>();
		
		for(int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if(!map.containsKey(c)) {
				map.put(c, 1);
			} else {
				map.put(c, map.get(c) + 1);
			}
		}
		
		int odd = 0;
		Character oddChar = null;
		StringBuilder left = new StringBuilder();
		for(Map.Entry<Character, Integer> e : map.entrySet()) {
			int val = e.getValue();
			char key = e.getKey();
			
			for(int i = 0; i < val / 2; i++) {
				left.append(key);
			}
			
			if(val % 2 != 0)  {
				odd++;
				oddChar = key;
			}
			if(odd > 1) return resList;
		}
		
		char[] cArr = left.toString().toCharArray();
		Arrays.sort(cArr);
		boolean[] visited = new boolean[left.length()];
		backtrack(resList, cArr, visited, new StringBuilder(), oddChar);
		
		return resList;
    }
	
	private void backtrack(List<String> resList, char[] chars, boolean[] visited, StringBuilder sb, Character oddChar) {
		if(sb.length() == chars.length) {
			StringBuilder left = new StringBuilder(sb);
			StringBuilder right = new StringBuilder(sb).reverse();
			if(oddChar != null) {
				left.append(oddChar);
			}
			left.append(right);
			resList.add(left.toString());
			return;
		}
		
		for(int i = 0; i < chars.length; i++) {
			
			if(!visited[i]) {
				
				if(i > 0 && chars[i] == chars[i-1] && !visited[i-1]) {
					continue;
				}
				
				visited[i] = true;
				sb.append(chars[i]);
				backtrack(resList, chars, visited, sb, oddChar);
				sb.deleteCharAt(sb.length() - 1);
				visited[i] = false;
				
			}
			
		}
	}
	
}
