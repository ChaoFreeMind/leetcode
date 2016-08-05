import java.util.ArrayList;
import java.util.List;

public class Solution {
	
    public List<List<Integer>> generate(int numRows) {
    	List<List<Integer>> resList = new ArrayList<>();
    	if(numRows <= 0) return resList;
    	for(int i = 0; i < numRows; i++) {
    		List<Integer> row = new ArrayList<>();
    		//i row has i+1 elements
    		for(int j = 0; j <= i+1; j++) {
    			if(j == 0 || j == i+1) {
    				row.add(1);
    			} else {
    				row.add(resList.get(i-1).get(j) + resList.get(i-1).get(j-1));
    			}
    		}
    		
    		resList.add(row);
    	}
    	
    	return resList;
    }
    
}