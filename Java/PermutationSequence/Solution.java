public String getPermutation(int n, int k) {
		
		List<Integer> digits = new ArrayList<Integer>();
		for(int i = 1; i <= n; i++) {
			digits.add(i);
		}
		
		//Generate factorial
		int[] factorials = new int[n + 1];
		factorials[0] = 1;
		for(int i = 1; i < factorials.length; i++) {
			factorials[i] = factorials[i-1] * i;
		}
		
		k--;//Convert k to zero-based!
		
		StringBuilder sb = new StringBuilder();
		//First locate the index of digit we choose in digits list.
		for(int i = n; i >= 1; i--) {
			int index = k / factorials[i-1];
			sb.append(digits.get(index));
			digits.remove(index);
			k = k % factorials[i-1];
		}
		
		return sb.toString();
	}