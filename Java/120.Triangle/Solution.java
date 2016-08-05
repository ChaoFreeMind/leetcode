import java.util.List;

//Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
//
//For example, given the following triangle
//[
//     [2],
//    [3,4],
//   [6,5,7],
//  [4,1,8,3]
//]
//The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
//
//Note:
//Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.

public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
    	int[] minDepth = new int[triangle.size()];
    	for(int i = 0; i < triangle.size(); i++) {
    		List<Integer> row = triangle.get(i);
    		for(int j = i; j >= 0; j--) {
    			if(j == i) {//if we are at the last element, just set it
    				minDepth[j] = minDepth[j-1] + row.get(j);
    			} else if(j == 0) {
    				minDepth[j] = minDepth[j] + row.get(j);
    			} else {
    				minDepth[j] = Math.min(minDepth[j-1], minDepth[j]) + row.get(j);
    			}
    		}
    	}
    	
    	int min = Integer.MAX_VALUE;
    	for(int i = 0; i < minDepth.length; i++)
    		min = Math.min(min, minDepth[i]);
    	return min;
    }
}