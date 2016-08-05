# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
from collections import deque

class Solution(object):

    def levelOrder(self, root):
        """
        :type root: TreeNode
        :rtype: List[List[int]]
        """
        res = []
        queue = deque()
        if not root:
            return res
        queue.append(root)

        while queue:
            size = len(queue)
            level = []
            for i in xrange(size):
                node = queue.popleft()
                if node.left: queue.append(node.left) 
                if node.right: queue.append(node.right)
                level.append(node.val)
            res.append(level)
        return res

    def levelOrderListComprehension(self, root): 
        if not root: return []

        res, level = [], [root]
        
        while level:
            # Add previous level to the result list
            res.append([node.val for node in level])

            # Expand previous level to a list of left right children tuple
            pairs = [(node.left,node.right) for node in level if node]

            # Expand tuple into our level list
            level = [node for pair in pairs for node in pair if node]
        return res

    # Improvement
    def levelOrderListComprehension2(self, root):
        if not root: return []
        res, level = [], [root]
        while level:
            # Add previous level into result list
            res.append([node.val for node in level])
            level = [child for node in level for child in (node.left, node.right) if child]
        return res