import java.util.ArrayDeque;
import java.util.Deque;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	int count;
	TreeNode(int x) {
		val = x;
	}
}
//Follow up:
//What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? 
//How would you optimize the kthSmallest routine?

//Solution for follow up: augment TreeNode with a count field which stores the number of nodes in the tree whose root is current node.
public class Solution {
	
	private int augmentTree(TreeNode root) {
		if(root == null) return 0;
		int leftCount = augmentTree(root.left);
		int rightCount = augmentTree(root.right);
		root.count = 1 + leftCount + rightCount;
		return root.count;
	}
	
	public int kthSmallest(TreeNode root, int k) {
		augmentTree(root);
		return binarySearch(root, k);
	}
	
	private int binarySearch(TreeNode root, int k) {
		if(root.left != null) {
			//Root is the node we want
			if(root.left.count == k - 1) {
				return root.val;
			} else if(root.left.count < k - 1) {//Search right branch
				return binarySearch(root.right, k - root.left.count - 1);
			} else {//Search left branch
				return binarySearch(root.left, k);
			}
		} else {
			if(k == 1) return root.val;
			return binarySearch(root.right, k - 1);
		}
	}
	
	//Since we may need to traverse k nodes in bst, so the time complexity is O(k), not quite efficient.
	/*public int kthSmallest(TreeNode root, int k) {
		TreeNode cur = root;
		Deque<TreeNode> stack = new ArrayDeque<>();
		stack.push(root);
		while(cur != null || !stack.isEmpty()) {
			if(cur != null) {
				stack.push(cur);
				cur = cur.left;
			} else {
				TreeNode node = stack.pop();
				k--;
				if(k == 0) return node.val;
				cur = node.right;
			}
		}
		//Not found
		return -1;
	}*/
	
}