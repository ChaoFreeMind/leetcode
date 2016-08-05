# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution(object):
    def isSameTree(self, p, q):
        """
        :type p: TreeNode
        :type q: TreeNode
        :rtype: bool
        """
        if p is None and q is None: 
        	return True
        # Both p and q are not None
        elif p and q:
        	return p.val == q.val and self.isSameTree(p.right, q.right) and self.isSameTree(p.left, q.left)
        else:
        	return False

    # Revised
    def isSameTree(self, p, q): 
    	if p and q: 
    		return p.val == q.val and self.isSameTree(p.right, q.right) and self.isSameTree(p.left, q.left)
    	# When comparing with None, use is instead of == as a general rule
    	return p is q