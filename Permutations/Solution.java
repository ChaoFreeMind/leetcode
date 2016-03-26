public class Solution {
    
   public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> resList = new ArrayList<>();
		boolean[] visited = new boolean[nums.length];
		DFS(resList, new ArrayList<Integer>(), visited, nums);
		
		return resList;
	}
	
	private void DFS(List<List<Integer>> resList, List<Integer> path, boolean[] visited, int[] nums) {
		
		if(path.size() == nums.length) {
			resList.add(new ArrayList<>(path));
			return;
		}
		
		for(int i = 0; i < nums.length; i++) {
			
			if(!visited[i]) {
				
				visited[i] = true;
				path.add(nums[i]);
				
				DFS(resList, path, visited, nums);
				
				path.remove(path.size() - 1);//Think of it as a stack
				visited[i] = false;
				
			}
			
		}
		
	}
}