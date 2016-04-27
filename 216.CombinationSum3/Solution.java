import java.util.ArrayList;
import java.util.List;

public class Solution {
 
	public List<List<Integer>> combinationSum3(int k, int n) {
    
		List<List<Integer>> resList = new ArrayList<>();
		List<Integer> comb = new ArrayList<>();
		backtrack(resList, comb, n, 1, k);
		return resList;
    }
	
	private void backtrack(List<List<Integer>> resList, List<Integer> comb, int target, int start, int k) {
		if(comb.size() == k) {
			if(target == 0) resList.add(new ArrayList<>(comb));
			return;
		}
		
		for(int i = start; i < 10; i++) {
			comb.add(i);
			backtrack(resList, comb, target - i, i + 1, k);
			comb.remove(comb.size() - 1);//Backtrack
		}
	}
	
}