public List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> resList = new ArrayList<>();
		List<Integer> comb = new ArrayList<>();
		backtrack(resList, comb, k, n, 1);
		return resList;
    }
	
	private void backtrack(List<List<Integer>> resList, List<Integer> comb, int k, int n, int pos) {
		if(comb.size() == k) {
			resList.add(new ArrayList<>(comb));
			return;
		}
		for(int i = pos; i <= n; i++) {
			comb.add(i);
			backtrack(resList, comb, k, n, i+1);
			comb.remove(comb.size() - 1);//Backtrack
		}	
	}