class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) {
		val = x;
	}
}

public class Solution {
	private int sum = 0;
	
	public int sumNumbers(TreeNode root) {
		if(root == null) return 0;
		dfs(root, 0);
		return sum;
	}
	
	private void dfs(TreeNode root, int num) {
		if(root == null) return;
		num += num * 10 + root.val;
		if(root.left == null && root.right == null) {
			sum += num;
		}
		
		dfs(root.left, num);
		dfs(root.right, num);
	}
	/*
	private void dfs(TreeNode root, String s) {
		if(root == null) return;
		s += root.val;
		if(root.left == null && root.right == null) {
			sum += Integer.parseInt(s);
		}
		
		dfs(root.left, s);
		dfs(root.right, s);
	}*/
}