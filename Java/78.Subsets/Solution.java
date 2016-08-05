public class Solution {
	
	public static void main(String[] args) {
		int[] nums = {1,2}; 
		System.out.println(new Solution().subsets(nums));
	}
	
    public List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);
    	List<List<Integer>> resList = new ArrayList<>();
    	List<Integer> comb = new ArrayList<>();
    	resList.add(new ArrayList<>());
    	backtrack(resList, comb, nums, 0);
    	return resList;
    }
    
    private void backtrack(List<List<Integer>> resList, List<Integer> comb, int[] nums, int start) {
    	
    	for(int i = start; i < nums.length; i++) {
    		comb.add(nums[i]);
    		resList.add(new ArrayList<>(comb));
    		backtrack(resList, comb, nums, i + 1);
    		comb.remove(comb.size() - 1);
    	}
    }
}