public class Solution {
	// Distinct numbers
    public List<List<Integer>> permute(int[] nums) {
    	List<List<Integer>> result = new ArrayList<>();
        genPerm(nums, new ArrayList<>(), new boolean[nums.length], result);
        return result;
    }

    private void genPerm(int[] nums, List<Integer> row, boolean[] visited, List<List<Integer>> result) {
    	
    	if (row.size() == nums.length) {
    		result.add(new ArrayList<Integer>(row));
    		return ;
    	}

    	for (int i = 0; i < nums.length; i++) {
    		if (!visited[i]) {
    			visited[i] = true;
    			row.add(nums[i]);
    			genPerm(nums, row, visited, result);
    			row.remove(row.size() - 1);
    			visited[i] = false;
    		}
    	}
    }

}