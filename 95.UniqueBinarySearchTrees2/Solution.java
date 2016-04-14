import java.util.ArrayList;
import java.util.List;


class TreeNode {
	int val;
	TreeNode(int x) {val = x;}
	TreeNode left;
	TreeNode right;
}
 
public class Solution {

	public List<TreeNode> generateTrees(int n) {
        return genBST(1, n);
    }
	
	//Generate all unique bsts whose val range from start to end
	private List<TreeNode> genBST(int start, int end) {
		List<TreeNode> resList = new ArrayList<>();
		if(start > end) {
			resList.add(null);
			return resList;
		}
		if(start == end) {
			TreeNode root = new TreeNode(start);
			resList.add(root);
			return resList;
		}
		
		for(int i = start; i <= end; i++) {
			//i as root, build left and right sub-tree recursively
			List<TreeNode> left = genBST(start, i-1);
			List<TreeNode> right = genBST(i+1, end);
			for(TreeNode lnode : left) {
				for(TreeNode rnode: right) {
					TreeNode root = new TreeNode(i);
					root.left = lnode;
					root.right = rnode;
					resList.add(root);
				}
			}
			
		}
		return resList;
		
	}
	
}
