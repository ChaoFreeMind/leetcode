import java.util.ArrayList;
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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> resList = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(resList, path, root, sum);
        return resList;
    }
    
    private void dfs(List<List<Integer>> resList, List<Integer> path, TreeNode root, int sum) {
    	
    	if(root == null) return;
    	
    	if(root.left == null && root.right == null && root.val == sum) {
    		//Found a result
    		path.add(root.val);
    		resList.add(new ArrayList<>(path));
    		path.remove(path.size() - 1);
    		return;
    	}
    	
    	path.add(root.val);
    	dfs(resList, path, root.left, sum - root.val);
    	dfs(resList, path, root.right, sum - root.val);
    	path.remove(path.size() - 1);//Remove the last element
    }
}