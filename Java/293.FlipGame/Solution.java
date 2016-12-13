public class Solution {
	// Keep a sliding window of size two, scan from left to right.

	// Very slow
    // public List<String> generatePossibleNextMoves(String s) {
    // 	List<String> result = new ArrayList<>();
	//	   int len = s.length();
    //     for (int i = 0; i < len - 1; i++) {
    //     	StringBuilder sb = new StringBuilder(s);
    //     	if ((s.charAt(i) == '+') && (s.charAt(i+1) == '+')) {
    //     		// Flip and add to result list
    //     		sb.setCharAt(i, '-');
    //     		sb.setCharAt(i + 1, '-');
    //     		result.add(sb.toString());
    //     	}
    //     }

    //     return result;
    // }

	// Since java 7, substring becomes O(n) operation, it ditched the char[] sharing, and maintains a 
	// char array for each string.
    public List<String> generatePossibleNextMoves(String s) {
    	List<String> result = new ArrayList<>();
    	int len = s.length();
        for (int i = 0; i < len - 1; i++) {
        	if ((s.charAt(i) == '+') && (s.charAt(i+1) == '+')) {
        		result.add(s.substring(0, i) + "--" + s.substring(i + 2, len));
        	}
        }

        return result;
    }
}