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
	// Find number of desired path, the path could start from any node.
    public int pathSum(TreeNode root, int sum) {
    	if (root == null) return 0;
    	return findPath(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }

    // Find number of desired path *only starting from root*.
    private int findPath(TreeNode root, int sum) {
    	int res = 0;
    	if (root == null) return 0;
    	if (root.val == sum) res++;
    	res += findPath(root.left, sum - root.val) + findPath(root.right, sum - root.val);
    	return res;
    }
}