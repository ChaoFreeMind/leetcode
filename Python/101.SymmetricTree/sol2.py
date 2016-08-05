# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    # Recursive
    def isSymmetric(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """
        return not root or self.check(root.left, root.right)

    def check(self, left, right):
        """
        :type left: TreeNode
        :rtype: bool
        """
        if left and right and left.val == right.val:
            return self.check(left.left, right.right) and self.check(left.right, right.left)
        elif not left and not right:
            return True
        else: 
            return False