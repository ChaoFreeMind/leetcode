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
	//Too slow barely accepted
	//Run bfs from right to left level by level, save the first element of each level to the result list.
    /*public List<Integer> rightSideView(TreeNode root) {
        List<Integer> resultList = new ArrayList<>();
        Deque<TreeNode> queue = new ArrayDeque<>();
        if(root == null) return resultList;
        queue.offer(root);

        while(!queue.isEmpty()) {
        	int size = queue.size();
        	for(int i = 0; i < size; i++) {
        		TreeNode node = queue.poll();
        		if(i == 0) resultList.add(node.val);
        		if(node.right != null) queue.offer(node.right);
        		if(node.left != null) queue.offer(node.left);
        	}
        }

        return resultList;
    }*/

    public List<Integer> rightSideView(TreeNode root) {
    	List<Integer> resultList = new ArrayList<>();

    	TreeNode cur = root;
    	while(cur != null) {
    		
    	}

    	return resultList;
    }
}