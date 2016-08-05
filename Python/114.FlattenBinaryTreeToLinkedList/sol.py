class Solution(object):
    def flatten(self, root):
        """
        :type root: TreeNode
        :rtype: void Do not return anything, modify root in-place instead.
        """
        if not root:
            return None
        right = root.right
        if root.left:
            self.flatten(root.left)
            
            tail = root.left
            while tail.right:
                tail = tail.right

            # Pythonic
            root.left, root.right, tail.right = None, root.left, right
        self.flatten(right)
        
        # Iterative
    def flatten(self, root):
        if not root: 
            return None

        while root:
            if not root.left:
                root = root.right
                continue
            left = root.left
            while left.right:
                left = left.right
            # now left is pointing to the right most tail of the left subtree
            root.left, left.right, root.right = None, root.right, root.left
            root = root.right