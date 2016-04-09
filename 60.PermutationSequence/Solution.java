//n would be 1 to 9 inclusive
    public String getPermutation(int n, int k) {
    	k--;//To convert k into zero-based
    	
    	List<Integer> digits = new ArrayList<>();
    	for(int i = 1; i <= n; i++)
    		digits.add(i);
    	
    	int[] factor = new int[n+1];
    	factor[0] = 1;
    	for(int i = 1; i < factor.length; i++) {
    		factor[i] = factor[i-1] * i;
    	}
    	
    	StringBuilder sb = new StringBuilder();
    	while(digits.size() > 0) {
    		int index = k / factor[n-1];
    		sb.append(digits.get(index));
    		digits.remove(index);
    		k = k % factor[n-1];
    		n--;
    	}
    	
    	return sb.toString();
    }