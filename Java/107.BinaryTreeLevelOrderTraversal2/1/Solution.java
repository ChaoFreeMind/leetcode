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
    	List<List<Integer>> resList = new LinkedList<>();
    	if(root == null) return resList;
    	Deque<TreeNode> queue = new ArrayDeque<>();
    	queue.offer(root);
    	while(!queue.isEmpty()) {
    		int levelSize = queue.size();
    		List<Integer> row = new LinkedList<>();
    		for(int i = 0; i < levelSize; i++) {
    			TreeNode node = queue.poll();
    			row.add(node.val);
    			if(node.left != null) queue.offer(node.left);
    			if(node.right != null) queue.offer(node.right);
    		}
    		resList.add(0, row);
    	}
    	
    	return resList;
    }
}