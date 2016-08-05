public class Solution {
    public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> resList = new ArrayList<>();
		
		if(nums == null || nums.length == 0)
			return resList;
		
		List<Integer> perm = new ArrayList<>();
		boolean[] visited = new boolean[nums.length];
		backtrack(resList, perm, visited, nums);
		
		return resList;
    }
	
	private void backtrack(List<List<Integer>> resList, List<Integer> perm, boolean[] visited, int[] nums) { 
		if(perm.size() == nums.length) {
			resList.add(new ArrayList<>(perm));
			return;
		}
		
		for(int i = 0; i < nums.length; i++) {
			if(!visited[i]) {
				//Visit current element, add it to permutation list, go down another level
				visited[i] = true;
				perm.add(nums[i]);
				backtrack(resList, perm, visited, nums);
				perm.remove(perm.size() - 1);//Remove last element, because we just returned from the lower level.
				visited[i] = false;
			}
		}
	}
}