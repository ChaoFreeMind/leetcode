# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    # Iterative
    def isSymmetric(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """
        if root is None: return True
        stack = [(root.left, root.right)]
        while stack:
            first, second = stack.pop()
            # Both first and second are None
            if not first and not second:
                continue
            elif first and second and first.val == second.val:
                stack.append((first.left, second.right))
                stack.append((first.right, second.left))
            else:
                return False
        return True