// Given a binary search tree (BST) with duplicates, find all the mode(s) 
// (the most frequently occurred element) in the given BST.

// Assume a BST is defined as follows:

// The left subtree of a node contains only nodes with keys less than or equal 
// to the node's key.
// The right subtree of a node contains only nodes with keys greater than or 
// equal to the node's key.
// Both the left and right subtrees must also be binary search trees.
// For example:
// Given BST [1,null,2,2],
//    1
//     \
//      2
//     /
//    2
// return [2].

// Note: If a tree has more than one mode, you can return them in any order.

// Follow up: Could you do that without using any extra space? (Assume that 
// the implicit stack space incurred due to recursion does not count).

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class Solution {

    public int[] findMode(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        
        Integer prev = null;
        int maxFreq = 0;    
        int curFreq = 0;
        Integer curVal = null;
        TreeNode cur = root;
        Deque<TreeNode> stack = new ArrayDeque<>();
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                // When you reached the left end, pop the stack
                TreeNode node = stack.pop();
                if (prev == null) {
                    curFreq++;
                    curVal = node.val;
                    maxFreq = 1;
                    prev = node.val;
                    list.add(curVal);
                }

                if (prev == node.val) {
                    curFreq++;
                    if (curFreq > maxFreq) {
                        maxFreq = curFreq;
                        list.clear();
                        list.add(curVal);
                    } else {
                        
                    }
                } 
                cur = node.right;
            }
        }

        return convertIntListToArray(modeList);
    }

    private int[] convertIntListToArray(List<Integer> list) {
        int[] res = new int[list.size()];
        for (int i = 0 ; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}