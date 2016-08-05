# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

# In python, to represent infinity, use: float('-inf') and float('inf')
class Solution(object):
    # Origin
    def isValidBST(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """
        return self.check(root, float('-inf'), float('inf'))
    
    def check(self, node, lowerbound, upperbound):
        if not node: return True
        return lowerbound < node.val < upperbound and self.check(node.left, lowerbound, node.val) and \
        self.check(node.right, node.val, upperbound)

    # To improve, merge check into isValidBST

    def isValidBST(self, root, lowerbound = float('-inf'), upperbound = float('inf')):
        if not node: return True
        return lowerbound < node.val < upperbound and self.check(node.left, lowerbound, node.val) and \
        self.check(node.right, node.val, upperbound)

    # Iterative version in-order traversal
    # Taking advantage of the nature of BST, inorder traversal would be sorted!
    def isValidBST(self, root):
        stack = []
        prev = float('-inf')
        while stack or root:
            if root:
                stack.append(root)
                root = root.left
            # Reached the left most child
            else:
                node = stack.pop();
                if prev >= node.val:
                    return False
                prev = node.val
                root = node.right

        return True


