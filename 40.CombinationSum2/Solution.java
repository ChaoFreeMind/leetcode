//[1, 1]??
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		
		List<List<Integer>> resList = new ArrayList<>();
		//invalid candidate array, return empty result list
		if(candidates == null || candidates.length == 0) 
			return resList;
		//Combination list to collect combination along the way.
		List<Integer> comb = new ArrayList<>();
		Arrays.sort(candidates);
		backtrack(resList, comb, candidates, target, 0);
		
		return resList;
	}
	
	
	private void backtrack(List<List<Integer>> resList, List<Integer> comb, int[] candidates, int remain, int start) {
		//Found a combination!
		if(remain == 0) {
			resList.add(new ArrayList<>(comb));//comb is a mutable array list, our result list should be static lists.
			return;
		} else if(remain < 0) {
			//sum > target, we dont need to keep searching, just return
			return;
		} else {
			//Backtracking logic, iterate through the candidates array, 
			for(int i = start; i < candidates.length; i++) {
				if(i > start && candidates[i] == candidates[i-1]) continue;//This line of code is the key!
				comb.add(candidates[i]);//Search current candidate, check if it is valid in the next level.
				backtrack(resList, comb, candidates, remain - candidates[i], i + 1);
				comb.remove(comb.size() - 1);//Remove last element in combination, backtracking!
			}
			
		}		
	}