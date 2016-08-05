# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution(object):
    # Recursive
    def preorderTraversal(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        res = []
        if root:
            res.append(root.val)
            res.extend(self.preorderTraversal(root.left))
            res.extend(self.preorderTraversal(root.right))
        return res

    # Iterative
    def preorderTraversal(self, root):
        stack = []
        ans = []
        while stack or root:
            if root:
                ans.append(root.val)
                stack.append(root)
                root = root.left
            else:
                node = stack.pop()
                root = node.right
        return ans


