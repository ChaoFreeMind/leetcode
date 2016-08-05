import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
//ust close in the correct order, "()" and "()[]{}" 
//are all valid but "(]" and "([)]" are not.

public class Solution {

	public boolean isValid(String s) {
		// String == null?
		if (s.length() % 2 != 0)
			return false;
		Map<Character, Character> map = new HashMap<>();
		initMap(map);
		Deque<Character> stack = new ArrayDeque<>();

		for (int i = 0; i < s.length(); i++) {
			if (map.containsKey(s.charAt(i))) {
				// Left half of parentheses
				stack.push(s.charAt(i));
			} else {
				// right half of parentheses
				Character top = stack.peek();//return null when stack is empty
				if(top == null) return false;//Empty
				// We only push element to stack when it is a left half of a
				// parentheses
				if (map.get(top) != s.charAt(i))
					return false;
				stack.pop();

			}
		}

		return stack.isEmpty();// Dont forget case like {{((
	}

	private void initMap(Map<Character, Character> map) {
		map.put('{', '}');
		map.put('(', ')');
		map.put('[', ']');
	}

}
