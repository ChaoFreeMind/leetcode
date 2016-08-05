class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) {
		val = x;
	}
}

public class Solution {
	
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		return buildTree(0, 0, inorder.length - 1, preorder, inorder);
    }
	
	private TreeNode buildTree(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder) {
		
		if(preStart > preorder.length - 1 || inEnd < inStart) return null;
		
		TreeNode root = new TreeNode(preorder[preStart]);//preorder[preStart] is the root
		int inIdx = -1;
		for(int i = inStart; i <= inEnd; i++) {
			if(inorder[i] == root.val) {
				inIdx = i;
				break;
			}
		}
		//Number of elements in the left subtree: inIdx - inStart
		//Number of elements in the right subtree: inEnd - inIdx
		root.left = buildTree(preStart + 1, inStart, inIdx - 1, preorder, inorder);
		root.right = buildTree(preStart + 1 + inIdx - inStart, inIdx + 1, inEnd, preorder, inorder);
		return root;
	}
	
}
