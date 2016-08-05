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
	public boolean isSymmetric(TreeNode root) {
		if(root == null) return true;
		Deque<TreeNode> queue = new LinkedList<>();//ArrayDeque will not accept null elements!!!
		queue.offer(root.left);
		queue.offer(root.right);
		while(!queue.isEmpty()) {
			TreeNode nodeA = queue.poll();
			TreeNode nodeB = queue.poll();
			if(nodeA == null && nodeB == null) continue;
			else if(nodeA != null && nodeB != null && nodeA.val == nodeB.val) {
				queue.offer(nodeA.left);
				queue.offer(nodeB.right);
				queue.offer(nodeA.right);
				queue.offer(nodeB.left);
			} else {
				return false;
			}
		}

		return true;
	}
}