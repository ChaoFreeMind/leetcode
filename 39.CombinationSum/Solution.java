public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> resList = new ArrayList<>();
		if(candidates == null || candidates.length == 0) return resList;
		Arrays.sort(candidates);
		List<Integer> comb = new ArrayList<>();
		backtrack(resList, comb, candidates, target, 0);
		return resList;
	}

	private void backtrack(List<List<Integer>> resList, List<Integer> comb, int[] candidates, int remain, int pos) {
		if(remain == 0) {
			//If sum is equal to target, then we have found a combination.
			resList.add(new ArrayList<>(comb));
			return;
		}
		
		if(remain < 0) return;
		
		for(int i = pos; i < candidates.length; i++) { 
			comb.add(candidates[i]);
			backtrack(resList, comb, candidates, remain - candidates[i], i);
			comb.remove(comb.size() - 1);//Backtrack
		}
		
	}