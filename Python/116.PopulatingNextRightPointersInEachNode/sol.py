# Definition for binary tree with next pointer.
# class TreeLinkNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
#         self.next = None

class Solution(object):
    # Slow recursive way
    def connect(self, root):
        """
        :type root: TreeLinkNode
        :rtype: nothing
        """
        if not root:
            return
        # Perfect binary tree if there is a left node, there will be a whole level of nodes.
        if root.left:
            root.left.next = root.right
            root.right.next = root.next and root.next.left
        self.connect(root.left)
        self.connect(root.right)

    # Iterative So Clean
    def connect2(self, root):
        # Traverse the tree level by level
        while root and root.left:
            # For each level
            next = root.left
            while root:
                root.left.next = root.right
                root.right.next = root.next and root.next.left
                root = root.next
            root = next

