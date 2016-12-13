/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class Solution {
	// Straight forward recursion solution
    // public int depthSum(List<NestedInteger> nestedList) {
    // 	int depth = 1;
    // 	return depthSumHelper(nestedList, depth);
    // }

    // private int depthSumHelper(List<NestedInteger> nestedList, int depth) {
    // 	int sum = 0;
    // 	for (int i = 0; i < nestedList.size(); i++) {
    // 		NestedInteger nestedInt = nestedList.get(i);
    // 		sum += nestedInt.isInteger ? nestedInt.getInteger() : depthSumHelper(nestedInt.getList(), depth + 1);
    // 	}
    // 	return sum;
    // }

	// Using queue like level order traversal
	public int depthSum(List<NestedInteger> nestedList) {
		Deque<NestedInteger> queue = new LinkedList<>(nestedList);
		int depth = 1, sum = 0;
		
		while (!queue.isEmpty()) {
			// Level by level
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				NestedInteger ni = queue.poll();
				if (ni.isInteger()) {
					sum += depth * ni.getInteger();
				} else {
					queue.addAll(ni.getList());
				}
			}
			depth++;
		}

		return sum;
    }

}