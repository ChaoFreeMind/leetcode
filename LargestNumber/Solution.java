public String largestNumber(int[] nums) {
		//First convert nums to a list of string.
		List<String> sList = new ArrayList<>();
		for(int i = 0; i < nums.length; i++) {
			sList.add(String.valueOf(nums[i]));
		}
		
		//Sort all those strings
		Collections.sort(sList, new Comparator<String>() {
			public int compare(String a, String b) {
				a = a + b;
				b = b + a;
				return a.compareTo(b);
			}
		});
		
		//Build up the result by reversely going through the sList
		StringBuilder sb = new StringBuilder();
		
		for(int i = sList.size() - 1; i >= 0; i++) {
			sb.append(sList.get(i));
		}
		
		String res = sb.toString();
		if(res.startsWith("0") && res.length() > 1) return "0";
		
		return sb.toString();
	}