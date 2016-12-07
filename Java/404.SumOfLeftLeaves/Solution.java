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
	// Recursive
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        return (root.left != null && root.left.left == null && root.left.right == null ? root.left.val : 0) 
        + sumOfLeftLeaves(root.left) 
        + sumOfLeftLeaves(root.right);
    }


    // Stack
    public int sumOfLeftLeaves(TreeNode root) {
    	if (root == null) return 0;
    	int sum = 0;
    	Deque<TreeNode> stack = new LinkedList<>();
    	stack.push(root);
    	while (!stack.isEmpty()) {
    		TreeNode cur = stack.pop(), left = cur.left, right = cur.right;

    		if (left != null && left.left == null && left.right == null) sum += left.val;

    		if (left != null) stack.push(left);

    		if (right != null) stack.push(right);
    	}
    	return sum;
    }

    // Queue
    public int sumOfLeftLeaves(TreeNode root) {
    	if (root == null) return 0;
    	int sum = 0;
    	Deque<TreeNode> queue = new LinkedList<>();
    	queue.offer(root);
    	while (!queue.isEmpty()) {
    		TreeNode cur = queue.poll(), left = cur.left, right = cur.right;
    		if (left != null && left.left == null && left.right == null) sum += left.val;

    		if (left != null) queue.offer(left);

    		if (right != null) queue.offer(right);
    	}
    	return sum;
    }
}