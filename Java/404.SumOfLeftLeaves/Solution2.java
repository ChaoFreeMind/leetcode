// Find the sum of all left leaves in a given binary tree.

// Example:

//     3
//    / \
//   9  20
//     /  \
//    15   7

// There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.

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

    // Level order traversal, at count the number of 
    public int sumOfLeftLeaves(TreeNode root) {
        return dfs(root, false, 0);
    }

    private int dfs(TreeNode root, boolean isLeft, int sum) {
        if (root == null) return sum;
        if (isLeft && root.left == null && root.right == null) return sum + root.val;
        return dfs(root.right, false, sum) + dfs(root.left, true, sum);
    }
}