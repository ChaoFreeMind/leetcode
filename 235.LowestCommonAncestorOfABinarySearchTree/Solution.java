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
    //Recursive
	/*public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		
		if(root == null) return null;
		
		if((root.val > p.val && root.val < q.val) || (root.val < p.val && root.val > q.val)) 
			return root;
		
		if(root.val > p.val && root.val > q.val) 
			return lowestCommonAncestor(root.left, p, q);
		
		if(root.val < q.val && root.val < p.val)
			return lowestCommonAncestor(root.right, p, q);
		
		return root;
	}*/
	
	//Iterative
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		
		while(true) {
			if(root.val > p.val && root.val > q.val) {
				root = root.left;
			} else if(root.val < p.val && root.val < q.val) {
				root = root.right;
			} else {
				return root;
			}
		}
		
	}

}