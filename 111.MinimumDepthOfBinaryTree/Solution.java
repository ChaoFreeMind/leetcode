import java.util.Deque;
import java.util.LinkedList;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) {
		val = x;
	}
}

public class Solution {
	
	public int minDepth(TreeNode root) {
		if(root == null) return 0;
		int left = minDepth(root.left);
		int right = minDepth(root.right);
		return (left == 0 || right == 0) ? left + right + 1 : Math.min(left, right);
	}
	
	//Run BFS, stop when we found the first leaf node.
	/*public int minDepth(TreeNode root) {
		int depth = 0;
		if(root == null) return 0;
		Deque<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while(!queue.isEmpty()) {
			int levelSize = queue.size();
			depth++;
			for(int i = 0; i < levelSize; i++) {
				TreeNode node = queue.poll();
				if(node.left == null && node.right == null) {
					break;
				} 
				
				if(node.left != null) queue.offer(node.left);
				if(node.right != null) queue.offer(node.right);
			}
		}
		
		return depth;
	}*/
	
}