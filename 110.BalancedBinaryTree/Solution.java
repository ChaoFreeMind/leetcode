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
// 	public boolean isBalanced(TreeNode root) {
// 		if(root == null) return true;
// 		int left = getDepth(root.left);
// 		int right = getDepth(root.right);
// 		return Math.abs(left - right) <= 1 && isBalanced(root.left) && isBalanced(root.right);
// 	}
	
// 	private int getDepth(TreeNode root) {
// 		if(root == null) return 0;
// 		return Math.max(getDepth(root.left), getDepth(root.right)) + 1;
// 	}
    private boolean result = true; 
	
	public boolean isBalanced(TreeNode root) {
		getDepth(root);
		return result;
	}
	
	private int getDepth(TreeNode root) {
		if(root == null) return 0;
		int left = getDepth(root.left);
		int right = getDepth(root.right);
		if(Math.abs(left - right) > 1) result = false;
		return Math.max(left, right) + 1;
	}
}