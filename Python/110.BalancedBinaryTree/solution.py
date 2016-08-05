# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
	# Solution 1: 
	# The problem would be traversing the tree twice! 
	'''
    def isBalanced(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """
        if root is None:
        	return True
        else:
        	left_depth, right_depth = self.depth(root.left), self.depth(root.right)
        	return abs(left_depth - right_depth) <= 1 and self.isBalanced(root.left) and self.isBalanced(root.right)


    # Return the depth of a tree
    def depth(self, root):
    	"""
    	:type root: TreeNode
    	:rtype: int
    	"""
    	if root is None:
    		return 0
    	return 1 + max(self.depth(root.left), self.depth(root.right))
	'''
	# Solution 2: 
	def isBalanced(self, root):
		return self.check(root) != -1
	def check(self, root):
    	if root is None:
    		return 0

    	left, right = self.check(root.left), self.check(root.right)
    	if left == -1 or right == -1 or abs(left - right) > 1:
    		return -1

    	return 1 + max(left, right)

