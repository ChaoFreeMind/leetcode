import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

//Given a binary tree, return the vertical order traversal of its nodes' values. (ie, from top to bottom, column by column).
//
//If two nodes are in the same row and column, the order should be from left to right.
//
//Examples:
//Given binary tree [3,9,20,null,null,15,7],
//    3
//   / \
//  9  20
//    /  \
//   15   7
//return its vertical order traversal as:
//[
//  [9],
//  [3,15],
//  [20],
//  [7]
//]
//Given binary tree [3,9,20,4,5,2,7],
//    _3_
//   /   \
//  9    20
// / \   / \
//4   5 2   7
//return its vertical order traversal as:
//[
//  [4],
//  [9],
//  [3,5,2],
//  [20],
//  [7]
//]

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

// Preorder or inorder will not work!! Should use BFS!!
public class Solution {

	public List<List<Integer>> verticalOrder(TreeNode root) {

		List<List<Integer>> resList = new ArrayList<>();

		if (root == null)
			return resList;

		Map<Integer, List<Integer>> map = new HashMap<>();// Map from col to
															// colList

		// inorder(root, map, 0);

		// BFS code
		Deque<TreeNode> queue = new LinkedList<>();
		Deque<Integer> colQueue = new LinkedList<>();
		
		// BFS init
		queue.add(root);
		colQueue.add(0);
		int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
		
		while (!queue.isEmpty()) {

			TreeNode node = queue.poll();
			int col = colQueue.poll();
			
			if(!map.containsKey(col)) {
				map.put(col, new ArrayList<>());
			}
			
			map.get(col).add(node.val);
			
			min = Math.min(min, col);
			max = Math.max(max, col);
			
			if(node.left != null) {
				queue.add(node.left);
				colQueue.add(col - 1);
			}
			
			if(node.right != null) {
				queue.add(node.right);
				colQueue.add(col + 1);
			}
			
		}

		for (int i = min; i <= max; i++) {
			resList.add(map.get(i));
		}

		return resList;
	}

	// private void inorder(TreeNode root, Map<Integer, List<Integer>> map, int
	// col) {
	//
	// if(root == null) {
	// return;
	// }
	//
	// if(!map.containsKey(col)) {
	// map.put(col, new ArrayList<>());
	// }
	// map.get(col).add(root.val);
	//
	// min = Math.min(min, col);
	// max = Math.max(max, col);
	//
	// inorder(root.left, map, col - 1);
	// inorder(root.right, map, col + 1);
	// }

}
