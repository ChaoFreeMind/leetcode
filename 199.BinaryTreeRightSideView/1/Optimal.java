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
    //Traverse the tree in the order of root right left, everytime we comes to a new level, add the 
    //first node to the list

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> resultList = new ArrayList<>();
        if(root == null) return resultList;

        dfs(root, resultList, 0);

        return resultList;
    }

    private void dfs(TreeNode root, List<Integer> resultList, int level) {
        if(resultList.size() <= level) resultList.add(root.val);
        if(root.right != null) dfs(root.right, resultList, level + 1);
        if(root.left != null) dfs(root.left, resultList, level + 1);
    }
}