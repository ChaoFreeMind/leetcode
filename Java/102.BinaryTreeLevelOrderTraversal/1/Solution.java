public class Solution {
	//BFS Solution
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> resList = new ArrayList<>();
		if(root == null) return resList;
		
		Deque<TreeNode> queue = new ArrayDeque<>();
		queue.add(root);
		int level = 0;
		while(!queue.isEmpty()) {
			int size = queue.size();
			List<Integer> levelList = new ArrayList<>();
			//Enqueue level by level, so that we can populate the levelList.
			for(int i = 0; i < size; i++) {
				TreeNode node = queue.poll();
				levelList.add(node.val);
				if(node.left != null) queue.offer(node.left);
				if(node.right != null) queue.offer(node.right);
			}
			resList.add(level, levelList);
			level++;
		}
		
		return resList;
    }
	
}