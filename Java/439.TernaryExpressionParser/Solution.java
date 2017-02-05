public class Solution {

	// Stack solution
	public String parseTernary(String expression) {
		if (expression == null || expression.length() == 0) 
			return expression; 
		Deque<Character> stack = new LinkedList<>();
		for (int i = expression.length() - 1; i >= 0; i--) {
			char c = expression.charAt(i);
			if (stack.peek() == '?') {
				stack.pop(); // Remove '?'
				char left = stack.pop();
				stack.pop(); // Remove ':' 
				char right = stack.pop();
				if (c == 'T') {
					stack.push(left);
				} else {
					stack.push(right);
				}
			} else {
				stack.push(c);
			}
		}
		return stack.peek();
	}

    public String parseTernary(String expression) {
    	// Evaluate from right to left
    	int lastIdx = expression.lastIndexOf("?");

    	// Evaluate from right to left until it's done.
    	while (lastIdx != -1) {
    		// Extract the right most sub-expression
	    	String subExp = expression.substring(lastIdx - 1, lastIdx + 4);
    		String result = eval(subExp);
    		// expression = expression.replace(subExp, result);
    		expression = expression.substring(0, lastIdx - 1) + result + expression.substring(lastIdx + 4);
    		lastIdx = expression.lastIndexOf("?");
    	}
    	
    	return expression;
    }

    // expression will be non-divisible
    private String eval(String expression) {
    	return String.valueOf(expression.charAt(0) == 'T' ? expression.charAt(2) : expression.charAt(4));
    }


    // DFS solution, fast!
    public String parseTernary(String expression) {
        if(expression == null || expression.length() == 0){
            return expression;
        }
        char[] exp = expression.toCharArray();
        
        return DFS(exp, 0, exp.length - 1) + "";
        
    }
    public char DFS(char[] c, int start, int end){
        if(start == end){
            return c[start];
        }
        int count = 0, i =start;
        for(; i <= end; i++){
            if(c[i] == '?'){
                count ++;
            }else if (c[i] == ':'){
                count --;
                if(count == 0){
                    break;
                }
            }
        }
        return c[start] == 'T'? DFS(c, start + 2, i - 1) : DFS(c, i+1,end);
    }
}