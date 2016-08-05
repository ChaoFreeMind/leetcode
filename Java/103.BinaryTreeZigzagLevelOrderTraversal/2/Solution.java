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

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    	List<List<Integer>> resultList = new ArrayList<>();
    	if(root == null) return resultList;

        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);//Equivalent to offerLast
        int level = 0;
        while(!queue.isEmpty()) {
        	int size = queue.size();
        	resultList.add(new ArrayList<>());
        	
        	for(int i = 0; i < size; i++) {
        		TreeNode node = queue.poll();
        		if(node.left != null) queue.offer(node.left);
        		if(node.right != null) queue.offer(node.right);
        		if(level % 2 == 0) {
        			resultList.get(level).add(node.val);
        		} else {
        			resultList.get(level).add(0, node.val);
        		}
        	}

        	level++;
        }

        return resultList;
    }

}