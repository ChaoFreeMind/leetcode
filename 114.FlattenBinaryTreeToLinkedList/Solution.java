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
    //Recursive has a lot of overhead! 
    public void flatten(TreeNode root) {
		if(root == null) return;
		
		flatten(root.left);
		flatten(root.right);
		TreeNode right = root.right;
		root.right = root.left;
		root.left = null;
		//Go find the last element in left
		TreeNode last = root;
		while(last.right != null) {
			last = last.right;
		}
		last.right = right;
	}

}