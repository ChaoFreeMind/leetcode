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

    public int maxDepth(TreeNode root) {
    	if (root == null) return 0;
    	int leftDepth = maxDepth(root.left);   
    	int rightDepth = maxDepth(root.right);
    	return 1 + Math.max(leftDepth, rightDepth);
    }
    
    // Faster, maybe it is not a good idea to declare variables in recursion
    public int maxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        return 1+Math.max(maxDepth(root.left),maxDepth(root.right));
    }

}