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

	// public boolean isSameTree(TreeNode p, TreeNode q) {
 //        if (p == null && q == null) return true;
 //        if (p == null || q == null) return false;
 //        return (p.val == q.val) && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
 //    }


	// Level order traversal, not finished yet!
    public boolean isSameTree(TreeNode p, TreeNode q) {
    	Deque<TreeNode> queueA = new LinkedList<>(), queueB = new LinkedList<>();
    	queueA.offer(p);
    	queueB.offer(q);

    	while (!queueA.isEmpty() && !queueB.isEmpty()) {
    		TreeNode nodeA = queueA.poll();
    		TreeNode nodeB = queueB.poll();
    		if (nodeA != null && nodeB != null && nodeA.val != nodeB.val) return false;
    		if (nodeA == null && nodeB == null) continue;
    		if (nodeA == null || nodeB == null) return false;
    		queueA.offer(p);
    		queueB.offer(q);
    	}
    	return queueA.isEmpty() && queueB.isEmpty();
    }
}