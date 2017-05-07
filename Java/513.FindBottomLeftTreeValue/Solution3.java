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

// Basic idea is to traverse the tree from right to left level by level and the last element would be
// the bottom left value
public class Solution {
    public int findBottomLeftValue(TreeNode root) {
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        int res = Integer.MIN_VALUE;
        TreeNode cur = null;
        
        while (!queue.isEmpty()) {
          int size = queue.size();
          for (int i = 0; i < size; i++) {
            TreeNode node = queue.poll();
            res = node.val;
            if (node.right != null) queue.offer(node.right);
            if (node.left != null) queue.offer(node.left);
          }
        }

        return res;
    }
}



