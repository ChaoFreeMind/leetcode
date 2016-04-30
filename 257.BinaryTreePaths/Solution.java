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
	
	public List<String> binaryTreePaths(TreeNode root) {
		
		List<String> resList = new ArrayList<>();
		if(root != null) dfs(root, "", resList);
		return resList;
	}
	
	private void dfs(TreeNode root, String path, List<String> resList) {
		
		if(root.left == null && root.right == null) {
			path += root.val;
			resList.add(path);
			return;
		}
		path += root.val + "->";
		if(root.left != null) dfs(root.left, path, resList);
		if(root.right != null) dfs(root.right, path, resList);
	}
	
	/*private void dfs(TreeNode root, List<Integer> path, List<String> resList) {
		if(root == null) return;
		if(root.left == null && root.right == null) {
			path.add(root.val);
			resList.add(getPathString(path));
			path.remove(path.size() - 1);
			return;
		}
		path.add(root.val);
		dfs(root.left, path, resList);
		dfs(root.right, path, resList);
		path.remove(path.size() - 1);
	}
	
	private String getPathString(List<Integer> path) {
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < path.size(); i++) {
			sb.append(path.get(i));
			if(i != path.size()-1) sb.append("->");
		}
		return sb.toString();
	}*/
	
}