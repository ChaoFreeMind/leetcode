public class Solution {

	private void initMap(Map<Character, String> map) {
		map.put('2', "abc");
		map.put('3', "def");
		map.put('4', "ghi");
		map.put('5', "jkl");
		map.put('6', "mno");
		map.put('7', "pqrs");
		map.put('8', "tuv");
		map.put('9', "wxyz");
	}

    private void letterCombinationsHelper(String digits, int pos, StringBuilder sb, List<String> res, Map<Character, String> map) {
    	if (sb.length() == digits.length()) {
    		res.add(sb.toString());
    		return ;
    	}

    	for (int i = pos; i < digits.length(); i++) {
    		char digit = digits.charAt(i);
    		if (map.containsKey(digit)) {
    			for (char c: map.get(digit).toCharArray()) {
    				sb.append(c);
    				letterCombinationsHelper(digits, i + 1, sb, res, map);
    				sb.deleteCharAt(sb.length() - 1);
    			}
    		}
    	}
    }

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0) return res;
    	Map<Character, String> map = new HashMap<>();
    	initMap(map);
    	
    	StringBuilder sb = new StringBuilder();
    	letterCombinationsHelper(digits, 0, sb, res, map);
    	return res;
    }
}