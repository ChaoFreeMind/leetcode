public String convertToTitle(int n) {
    	StringBuilder sb = new StringBuilder();
    	while(n > 0) {
    		n--;
    		char c = (char)('A' + (n % 26));
    		sb.insert(0, c);
    		n /= 26;
    	}
    	return sb.toString();
    }