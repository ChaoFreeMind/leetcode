/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
    	List<List<Integer>> resultList = new LinkedList<>();



    	return resultList;
    }

    private void dfs(TreeNode root, int level, List<List<Integer>> resultList) {
    	if(root == null) return;
    	if(level >= resultList.size()) {
    		resultList.add(0, new ArrayList<>());
    	}

    	dfs(root.left, level + 1, resultList);
    	dfs(root.right, level + 1, resultList);
    	//Here is the tricky part!!
    	resultList.get(resultList.size() - i - 1).add(root.val);
    }
}