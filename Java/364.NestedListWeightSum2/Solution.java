/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */

// There are many ways to solve this problem.
public class Solution {

	private int maxDepth = 0;

    public int depthSumInverse(List<NestedInteger> nestedList) {
    	Map<Integer, Integer> sumMap = new HashMap<>();
    	DFS(nestedList, 1, sumMap);
        int sum = 0;
       	for (int i = 1; i <= maxDepth; i++) {
       		sum += sumMap.get(i) * (maxDepth - i + 1);
       	}
       	return sum;
    }

    private void DFS(List<NestedInteger> nestedList, int depth, Map<Integer, Integer> sumMap) {
    	if (depth > maxDepth) maxDepth = depth;

    	int levelSum = sumMap.getOrDefault(depth, 0);

    	for (NestedInteger ni: nestedList) {
    		if (!ni.isInteger()) {
    			DFS(ni.getList(), depth + 1, sumMap);
    		} else {
    			levelSum += ni.getInteger();
    		}
    	}
    	sumMap.put(depth, levelSum);
    }
}