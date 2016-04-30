public class Solution {
    public List<Integer> diffWaysToCompute(String input) {
		List<Integer> resList = new ArrayList<>();
		if(input == null || input.length() == 0) return resList;
		if(!input.contains("+") && !input.contains("-") && !input.contains("*")) {
			resList.add(Integer.parseInt(input));
			return resList;
		}
		
		for(int i = 0; i < input.length(); i++) {
			char ch = input.charAt(i);
			if(ch == '+' || ch == '-' || ch == '*') {
				List<Integer> leftList = diffWaysToCompute(input.substring(0, i));
				List<Integer> rightList = diffWaysToCompute(input.substring(i+1));
				for(int left: leftList) {
					for(int right: rightList) {
						switch(ch) {
						case '+': resList.add(left + right); break;
						case '-': resList.add(left - right); break;
						case '*': resList.add(left * right); break;
						default: break;
						}
					}
				}
			}
		}
		
		return resList;
    }
}