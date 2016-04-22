public class BSTIterator {

	Deque<TreeNode> stack = null;
	TreeNode cur = null;
	
	public BSTIterator(TreeNode root) {
		stack = new ArrayDeque<>();
		cur = root;
	}

	/** @return whether we have a next smallest number */
	public boolean hasNext() {
		return !stack.isEmpty() || cur != null;
	}

	/** @return the next smallest number */
	public int next() {
		while(cur != null || !stack.isEmpty()) {
			if(cur != null) {
				stack.push(cur);
				cur = cur.left;
			} else {//cur reached the end of left branch
				cur = stack.peek().right;
				break;
			}
		}
		
		return stack.pop().val;
	}
}