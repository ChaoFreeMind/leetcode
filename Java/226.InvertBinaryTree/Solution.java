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

	// Recursion will always have stack overflow problem when it comes to huge tree.
    public TreeNode invertTree(TreeNode root) {
    	if (root == null) return root;
		TreeNode tempLeft = invertTree(root.left);
		root.left = invertTree(root.right);
		root.right = tempLeft;
		return root;
    }

	// Level order traversal.
	public TreeNode invertTree(TreeNode root) {
		if (root == null) return null;
		Deque<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			TreeNode head = queue.poll();

			if (head.left != null) queue.offer(head.left);
			if (head.right != null) queue.offer(head.right);

			// Swap two children
			TreeNode temp = head.left;
			head.left = head.right;
			head.right = temp;
		}
		return root;
	}

	// DFS using stack
	public TreeNode invertTree(TreeNode root) {
		if (root == null) return null;
		Deque<TreeNode> stack = new LinkedList<>();
		stack.push(root);
		while (!stack.isEmpty()) {
			TreeNode top = stack.pop();
			if (top.left != null) stack.push(top.left);
			if (top.right != null) stack.push(top.right);

			TreeNode temp = top.left;
			top.left = top.right;
			top.right = temp;
		}
	}

}