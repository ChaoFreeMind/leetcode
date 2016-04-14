public boolean isValidBST(TreeNode root) {
		return validateByRange(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
	
	/**
	 * 
	 * @param node The tree node to be validated
	 * @param min The lower bound
	 * @param max The upper bound
	 * @return
	 */
	private boolean validateByRange(TreeNode node, int min, int max) {
		if(node == null) return true;
		if(node.val <= min || node.val >= max )
			return false;
		boolean left = validateByRange(node.left, min, node.val);
		boolean right = validateByRange(node.right, node.val, max);
		return left && right;
	}