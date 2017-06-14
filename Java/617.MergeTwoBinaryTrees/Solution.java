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
  public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
    if (t1 == null && t2 == null) return null;
    TreeNode newRoot = mergeNodes(t1, t2);
    newRoot.left = mergeTrees(getLeft(t1), getLeft(t2));
    newRoot.right = mergeTrees(getRight(t1), getRight(t2));
    return newRoot;
  }

  private TreeNode getLeft(TreeNode node) {
    return node != null ? node.left : null;
  }

  private TreeNode getRight(TreeNode node) {
    return node != null ? node.right : null;
  }

  private TreeNode mergeNodes(TreeNode t1, TreeNode t2) {
    if (t1 == null && t2 == null) return null;
    int val = 0;
    int leftVal = t1 == null ? 0 : t1.val;
    int rightVal = t2 == null ? 0 : t2.val;
    return new TreeNode(leftVal + rightVal);
  }
}