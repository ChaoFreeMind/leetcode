//Note that if we try to split "" with \\s+, we will get an array with one element ""
	//The key of this problem is to get rid of white spaces between each strings
    public String reverseWords(String s) {
    	if(s == null) return s;
    	s = s.trim();
    	String[] strs = s.split("\\s+");//One or more spaces
    	StringBuilder sb = new StringBuilder();
    	if(strs.length > 0) {
    		for(int i = s.length() - 1; i > 0; i--) {
        		sb.append(strs[i]);
        		sb.append(" ");
        	}
        	sb.append(strs[0]);
    	}
    	return sb.toString();
    }
    