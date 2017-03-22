// Given a binary tree, flatten it to a linked list in-place.

// For example,
// Given

//          1
//         / \
//        2   5
//       / \   \
//      3   4   6
// The flattened tree should look like:
//    1
//     \
//      2
//       \
//        3
//         \
//          4
//           \
//            5
//             \
//              6
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

    // public void flatten(TreeNode root) {
    //     if (root == null) return;
    //     flattenHelper(root);
    // }

    // private TreeNode flattenHelper(TreeNode root) {
    //     if (root.left == null && root.right == null) {
    //         return root;
    //     }

    //     TreeNode left = null, right = null;

    //     if (root.left != null) left = flattenHelper(root.left);
    //     if (root.right != null) right = flattenHelper(root.right);
    //     if (left == null) return root;

    //     // Get the right most node of the flattened left subtree and connect it to the right 
    //     // flattened subtree
    //     TreeNode lastOfLeft = left;
    //     while (lastOfLeft.right != null) {
    //         lastOfLeft = lastOfLeft.right;
    //     }

    //     TreeNode temp = root.right;
    //     root.right = left;
    //     lastOfLeft.right = temp;
    //     root.left = null;
    //     return root;
    // }

    private TreeNode prev = null;

    public void flatten(TreeNode root) {
        if (root == null)
            return;
        flatten(root.right);
        flatten(root.left);
        root.right = prev;
        root.left = null;
        prev = root;
    }
}