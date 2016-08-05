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
	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> resList = new ArrayList<>();
		Deque<TreeNode> stack = new ArrayDeque<>();
		if(root == null) return resList;
		
		TreeNode cur = root;
		while(cur != null || !stack.isEmpty()) {
			while(cur != null) {
				stack.push(cur);
				cur = cur.left;
			}
			
			cur = stack.pop();
			resList.add(cur.val);
			cur = cur.right;
		}
		
		return resList;
	}
}