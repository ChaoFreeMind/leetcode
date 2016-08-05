public List<List<Integer>> permuteUnique(int[] nums) {

		List<List<Integer>> resList = new ArrayList<>();
		// For invalid input, return empty list
		if (nums == null || nums.length == 0)
			return resList;
		Arrays.sort(nums);
		boolean[] visited = new boolean[nums.length];
		List<Integer> perm = new ArrayList<>();
		backtrack(resList, perm, nums, visited);

		return resList;
	}

	private void backtrack(List<List<Integer>> resList, List<Integer> perm,
			int[] nums, boolean[] visited) {
		if (perm.size() == nums.length) {
			resList.add(new ArrayList<>(perm));
			return;
		}

		for (int i = 0; i < nums.length; i++) {
			if (!visited[i]) {
				//We should not visit duplicates before current element.
				if(i > 0 && !visited[i-1] && nums[i] == nums[i-1]) continue;
				visited[i] = true;
				perm.add(nums[i]);
				backtrack(resList, perm, nums, visited);
				perm.remove(perm.size() - 1);
				visited[i] = false;
			}
		}

	}