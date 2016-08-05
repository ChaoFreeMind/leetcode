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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
		return buildTree(postorder.length - 1, 0, inorder.length - 1, inorder, postorder);
    }
	
	private TreeNode buildTree(int postEnd, int inStart, int inEnd, int[] inorder, int[] postorder) {
		
		if(postEnd < 0 || inStart > inEnd) return null;
		
		TreeNode root = new TreeNode(postorder[postEnd]);
		//Get the number of nodes of root's left and right subtrees from inorder array
		int mid = 0;//The index in inorder array that breaks the left and right subtree 
		for(int i = inStart; i <= inEnd; i++) {
			if(root.val == inorder[i]) {
				mid = i;
				break;
			}
		}
		
		//The number of nodes in left tree: mid - inStart
		//The number of nodes in right tree: inEnd - mid
		
		root.left = buildTree(postEnd - (inEnd - mid) - 1, inStart, mid - 1, inorder, postorder);
		root.right = buildTree(postEnd - 1, mid + 1, inEnd, inorder, postorder);
		
		return root;
	}
}