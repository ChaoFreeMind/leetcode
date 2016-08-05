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
    //DFS
    /*public int minDepth(TreeNode root) {
    	if(root == null) return 0;
    	int left = minDepth(root.left);
    	int right = minDepth(root.right);

		return (left != 0 && right != 0) ? Math.min(left, right) + 1 : left + right + 1;
    }*/
    
      //BFS
    public int minDepth(TreeNode root) {
    	//Traverse down level by level until we reach the first leaf node.
    	if(root == null) return 0;
    	Deque<TreeNode> queue = new LinkedList<>();
    	queue.offer(root);
    	int level = 0;
    	while(!queue.isEmpty()) {
    		int size = queue.size();
    		level++;
    		for(int i = 0; i < size; i++) {
    			TreeNode node = queue.poll();
    			if(node.left == null && node.right == null) return level;
    			if(node.left != null) queue.offer(node.left);
    			if(node.right != null) queue.offer(node.right);
    		}
    	}
    	return level;
    }
}