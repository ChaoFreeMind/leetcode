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
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
       	helper(root, result);
        return result;
    }

    // Get the height of the node. (Number of edges from node to the furthest leaf)
    private int helper(TreeNode node, List<List<Integer>> result) {
    	if (node == null) return -1;
        int left = getHeight(node.left);
        int right = getHeight(node.right);
    	int height = Math.max(left, right) + 1;

        if (result.size() == height) {
            result.add(new ArrayList<Integer>());
        }
        result.get(height).add(node.val);
    	return height;
    }
}