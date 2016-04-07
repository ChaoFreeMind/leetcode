public class Solution {
    public String countAndSay(int n) {
		
		String res = "1";
		
		while(n > 1) {
			StringBuilder sb = new StringBuilder();
			int counter = 1;
			for(int i = 0; i < res.length()-1; i++) {
				if(res.charAt(i) == res.charAt(i+1)) {
					counter++;
				} else {
					sb.append(counter).append(res.charAt(i));
					counter = 1;
				}
			}
			//For the last character
			sb.append(counter).append(res.charAt(res.length() - 1));
			res = sb.toString();
			n--;
		}
		
		return res;
    }
}