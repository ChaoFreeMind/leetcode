# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
from collections import deque
class Solution(object):
    # Recursive
    def minDepth(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        if not root: return 0
        if root.left and root.right:
            left = self.minDepth(root.left)
            right = self.minDepth(root.right)
            return min(left, right) + 1
        # If any of the child of root is None, our function will return 0 which should not be taken as min.
        else:  
            return max(self.minDepth(root.left), self.minDepth(root.right)) + 1

    # Iterative BFS
    def minDepth(self, root):
        if not root:
            return 0
        queue = deque([root])
        depth = 0
        while queue:
            size = len(queue)
            depth+=1
            for i in xrange(size):
                node = queue.popleft();
                if not any((node.left, node.right)):
                    return depth
                if node.left:
                    queue.append(node.left)
                if node.right:
                    queue.append(node.right)
        return depth

    # Iterative BFS Improvement
    def minDepth(self, root):
        if not root: return 0
        level = [(root.left, root.right)]
        depth = 0
        while level:
            depth += 1
            for pair in level: 
                if not any(pair): return depth
            # build next level
            level = [(child.left, child.right) for pair in level for child in pair if child]
        return depth


