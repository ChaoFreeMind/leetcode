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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> resultList = new ArrayList<>();
        dfs(root, resultList, 0);
        return resultList;
    }

    private void dfs(TreeNode root, List<List<Integer>> resultList, int level) {
        if(root == null) return;
        //This is the tricky part.
        if(level >= resultList.size()) resultList.add(new LinkedList<>());
        resultList.get(level).add(root.val);
        if(root.left != null) dfs(root.left, resultList, level + 1);
        if(root.right != null) dfs(root.right, resultList, level + 1);
    }
}