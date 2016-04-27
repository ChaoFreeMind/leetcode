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
	public int countNodes(TreeNode root) {
		if(root == null) return 0;
		int leftHeight = 0, rightHeight = 0;
		TreeNode cur = root;
		//Get the left height
		while(cur != null) {
			leftHeight++;
			cur = cur.left;
		}
		cur = root;
		//Get the right height
		while(cur != null) {
			rightHeight++;
			cur = cur.right;
		}
		//Perfectly filled binary tree.
		if(leftHeight == rightHeight) return (1 << leftHeight) - 1;
		
		return countNodes(root.left) + countNodes(root.right) + 1;
	}
}