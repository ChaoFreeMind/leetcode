/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

//BFS
public class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
    	List<List<Integer>> resultList = new LinkedList<>();
    	if(root == null) return resultList;
    	Deque<TreeNode> queue = new LinkedList<>();
    	queue.offer(root);
    	while(!queue.isEmpty()) {
    		int size = queue.size();
    		List<Integer> level = new LinekdList<>();
    		//For each node on the same level, 
    		for(int i = 0; i < size; i++) {
    			TreeNode node = queue.poll();
    			level.add(node);
    			if(node.left != null) queue.offer(node.left);
    			if(node.right != null) queue.offer(node.right);
    		}
    		resultList.add(0, level);
    	}


    	return resultList;
    }
}