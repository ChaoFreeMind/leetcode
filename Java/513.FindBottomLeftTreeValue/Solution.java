// Given a binary tree, find the leftmost value in the last row of the tree.

// Example 1:
// Input:

//     2
//    / \
//   1   3

// Output:
// 1
// Example 2: 
// Input:

//         1
//        / \
//       2   3
//      /   / \
//     4   5   6
//        /
//       7

// Output:
// 7
// Note: You may assume the tree (i.e., the given root node) is not NULL.

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

    private int maxLevel = 0;

    // Use a hash map to keep track of the first element of each level.
    public int findBottomLeftValue(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        inorder(root, 0, map);
    }

    private void inorder(TreeNode root, int level, Map<Integer, Integer> map) {
        if (root == null) {
            return;
        }

        // Update the maxLevel
        maxLevel = Math.max(maxLevel, level);

        inorder(root.left, level + 1);
        // If map does not contain current level yet, then the current node is the
        // left most node of the tree.
        if (!map.containsKey(level)) {
            map.put(level, root.val);
        }
        inorder(root.right, level + 1);
    }
}