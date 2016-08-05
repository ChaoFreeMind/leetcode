# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    # # Recursive MLE because of too many slicing
    # def buildTree(self, preorder, inorder):
    #     """
    #     :type preorder: List[int]
    #     :type inorder: List[int]
    #     :rtype: TreeNode
    #     """
    #     if preorder:
    #         root = TreeNode(preorder[0])
    #         root_idx = inorder.index(root.val)
    #         root.left = self.buildTree(preorder[1:root_idx+1], inorder[:root_idx])
    #         root.right = self.buildTree(preorder[root_idx+1:], inorder[root_idx+1:])
    #         return root
    
    def buildTree(self, preorder, inorder):
        if inorder:
            root = TreeNode(preorder.pop(0))
            root_idx = inorder.index(root.val)
            root.left = self.buildTree(preorder, inorder[:root_idx])
            root.right = self.buildTree(preorder, inorder[root_idx+1:])
            return root
            
    # Performance improvement, discard list slicing, use start and end indices instead
    # O(n) time, O(n) space
    def buildTree(self, preorder, inorder):
        
        def build(preorder, inorder, pre_start, pre_end, in_start, in_end, in_dict):
            if pre_start > pre_end or in_start > in_end: 
                return None
            root = TreeNode(preorder[pre_start])
            # idx = inorder.index(root.val)
            idx = in_dict[root.val]
            # left tree size: idx - in_start
            root.left = build(preorder, inorder, pre_start + 1, pre_start + idx - in_start, in_start, idx - 1, in_dict)
            root.right = build(preorder, inorder, pre_start + idx - in_start + 1, pre_end, idx + 1, in_end, in_dict)
            return root
            
        in_dict = {} # cache values' positions in inorder
        for i, val in enumerate(inorder):
            in_dict[val] = i
        size = len(preorder)
        return build(preorder, inorder, 0, size - 1, 0, size - 1, in_dict)