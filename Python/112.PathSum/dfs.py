class Solution(object):
    def hasPathSum(self, root, sum):
        """
        :type root: TreeNode
        :type sum: int
        :rtype: bool
        """
        # queue keeps track of tuples (cur node, current sum including cur node)
        if not root: 
            return False
        stack = [(root, root.val)]
        while stack:
            cur_node, cur_sum = stack.pop()
            if not cur_node.left and not cur_node.right and cur_sum == sum:
                return True;
            if cur_node.left:
                queue.append((cur_node.left, cur_sum + cur_node.left.val))
            if cur_node.right:
                queue.append((cur_node.right, cur_sum + cur_node.right.val))
                
        return False
