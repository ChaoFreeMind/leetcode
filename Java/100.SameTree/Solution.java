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
    	if (p != null) queueA.offer(p);
    	if (q != null) queueB.offer(q);

    	while (!queueA.isEmpty() && !queueB.isEmpty()) {
    		TreeNode nodeA = queueA.poll();
    		TreeNode nodeB = queueB.poll();
            if (nodeA.val != nodeB.val) return false;
            if (!(nodeA.left == null && nodeB.left == null || nodeA.left != null && nodeB.left != null)) {
                return false;
            }
            if (nodeA.left != null) queueA.offer(nodeA.left);
            if (nodeA.right != null) queueA.offer(nodeA.right);
            if (nodeB.left != null) queueB.offer(nodeB.left);
            if (nodeB.right != null) queueB.offer(nodeB.right);
    	}

    	return queueA.isEmpty() && queueB.isEmpty();
    }

    // Better.
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Deque<TreeNode> queueA = new LinkedList<>(), queueB = new LinkedList<>();
        if (p != null) queueA.offer(p);
        if (q != null) queueB.offer(q);

        while (!queueA.isEmpty() && !queueB.isEmpty()) {
            TreeNode nodeA = queueA.poll();
            TreeNode nodeB = queueB.poll();
            if (nodeA.val != nodeB.val) return false;
            
            if (nodeA.left != null) queueA.offer(nodeA.left);
            if (nodeB.left != null) queueB.offer(nodeB.left);

            if (queueA.size() != queueB.size()) return false;

            if (nodeA.right != null) queueA.offer(nodeA.right);
            if (nodeB.right != null) queueB.offer(nodeB.right);

            if (queueA.size() != queueB.size()) return false;
        }

        return queueA.isEmpty() && queueB.isEmpty();
    }

}