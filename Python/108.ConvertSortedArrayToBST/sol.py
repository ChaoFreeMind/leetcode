# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def sortedArrayToBST(self, nums, left = 0, right = len(nums) - 1):
        """
        :type nums: List[int]
        :rtype: TreeNode
        """
        if (left > right) return None
        mid = left + (right - left) / 2
        node = TreeNode(nums[mid])
        node.left = self.sortedArrayToBST(nums, left, mid - 1)
        node.right = self.sortedArrayToBST(nums, mid + 1, right)
        return node
