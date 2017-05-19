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
    // Overflow?
    private int curSum = 0;
    public TreeNode convertBST(TreeNode root) {
        helper(root);
        return root;
    }

    private void helper(TreeNode cur) {
        if (cur == null) return;
        helper(cur.right);
        int old = cur.val;
        cur.val += curSum;
        curSum += old;
        helper(cur.left);
    }
}