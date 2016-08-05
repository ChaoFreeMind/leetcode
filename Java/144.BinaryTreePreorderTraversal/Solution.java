import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) {
		val = x;
	}
}

public class Solution {
	//Inorder will need a cur pointer preorder does not!!
	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> resList = new ArrayList<>();
		if(root == null) return resList;
		Deque<TreeNode> stack = new ArrayDeque<>();
		stack.push(root);
		while(!stack.isEmpty()) {
			TreeNode node = stack.pop();
			resList.add(node.val);
			if(node.right != null) stack.push(node.right);
			if(node.left != null) stack.push(node.left);
		}
		return resList;
	}
	
}