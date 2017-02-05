public class Solution {
    public List<String> generatePossibleNextMoves(String s) {
        List<String> result = new ArrayList<>();
        int len = s.length();
      	
        if (s == null || len == 0) return result;

        for (int i = 0; i < len - 1; i++) {
        	if (s.charAt(i) == '+' && s.charAt(i+1) == '+') {
        		String ns = s.substring(0, i) + "--" + s.substring(i+2, len);
        		result.add(ns);
        	}
        }

        return result;
    }
}