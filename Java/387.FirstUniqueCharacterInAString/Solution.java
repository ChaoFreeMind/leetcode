public class Solution {
	
	// O(n) time, O(n) space	
    public int firstUniqChar(String s) {
    	Map<Character, Integer> map = new HashMap<>();
    	char[] carr = s.toCharArray();
    	for (char c: carr) {
    		if (map.containsKey(c)) {
    			map.put(c, map.get(c) + 1);
    		} else {
    			map.put(c, 1);
    		}
    	}

    	for (int i = 0; i < carr.length; i++) {
    		if (map.get(carr[i]) == 1) return i;
    	}
    	return -1;
    }


    // Char array instead of hashMap
    public int firstUniqChar(String s) {
   		int[] arr = new int[26];
   		Arrays.fill(arr, -1);
   		for (int i = 0; i < s.length(); i++) {
   			char c = s.charAt(i);
   			int diff = c-'a';
   			arr[diff]++;
   			if (arr[diff] == 0) {
   				arr[diff] = i;
   			} else if (arr[diff] > 0) {
   				arr[diff] = -1;
   			}
   		}
   		int res = Integer.MAX_VALUE;
   		// Go through the arr
   		for (int idx: arr) {
   			if (idx >= 0) res = Math.min(idx, res);
   		}

   		return res == Integer.MAX_VALUE ? -1 : res;
    }
}