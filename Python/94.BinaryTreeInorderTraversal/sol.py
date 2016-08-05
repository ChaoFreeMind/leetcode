# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def inorderTraversal(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        ans = []
        stack = []
        while stack or root:
            if root:
                stack.append(root.val);
                root = root.left
            else:
                node = stack.pop()
                ans.append(node)
                root = node.right
        return ans

