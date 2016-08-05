public class Solution {
    
    public boolean isValid(String s) {
		
		if(s.length() % 2 != 0) return false;
		
		Deque<Character> stack = new ArrayDeque<>();
		
		Map<Character, Character> map = new HashMap<>();
		map.put('(', ')');
		map.put('{', '}');
		map.put('[', ']');
		
		for(int i = 0; i < s.length(); i++) {
			
			char c = s.charAt(i);
			
			if(c == '(' || c == '{' || c == '[') {
				stack.push(c);
			}
			
			if(c == ')' || c == '}' || c == ']') {
				Character top = stack.peek();
				if(top == null) return false;
				if(map.get(top) != c) return false;
				stack.pop();
			}
			
			
		}
		
		return stack.isEmpty();
		
	}
    
    // public boolean isValid(String s) {
    //     int len = s.length();
    //     if(len % 2 != 0) {
    //         return false;
    //     }
        
    //     Stack<Character> stack = new Stack<Character>();
    //     boolean isValid = true;
    //     for(int i = 0; i < len; i++) {
    //         char c = s.charAt(i);
    //         if(c == '(' || c == '[' || c == '{') {
    //             stack.push(c);
    //         } else if(c == ')' || c == ']' || c == '}') {
    //             if(!stack.isEmpty()) {
    //                 char top = stack.peek();
    //                 if(!match(top, c)) {
    //                     isValid = false;
    //                     break; 
    //                 } else {
    //                     stack.pop();
    //                 }    
    //             } else {
    //                 return false;
    //             }
                
    //         }
    //     }
        
    //     if(!stack.isEmpty()) {
    //         return false;
    //     }
        
    //     return isValid;
        
    // }
    
    // private boolean match(char a, char b) {
    //     return a == '(' && b == ')' || a == '[' && b == ']' || a == '{' && b == '}'; 
    // }
}