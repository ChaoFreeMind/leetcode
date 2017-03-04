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

// O(n) time, Psuedo O(1) space but not really, check out 
// https://discuss.leetcode.com/topic/77335/proper-o-1-space/5 for proper O(1)
public class Solution {

    public int[] findMode(TreeNode root) {
        List<Integer> modeList = new ArrayList<>();
        
        Integer prev = null;
        int maxFreq = 0;    
        int curFreq = 0;

        TreeNode cur = root;
        Deque<TreeNode> stack = new ArrayDeque<>();

        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                // When you reached the left end, pop the stack
                TreeNode node = stack.pop();

                if (prev != null && prev == node.val) {
                    curFreq++;
                    if (curFreq > maxFreq) {
                        // We have a new mode, clear the list, add node.val to
                        // the list. We also need to update the maxFreq
                        modeList.clear();
                        modeList.add(node.val);
                        maxFreq = curFreq;
                    } else if (curFreq == maxFreq) {
                        modeList.add(node.val);
                    }
                } else {
                    // Update prev to current node value.
                    prev = node.val;
                    curFreq = 1;

                    if (curFreq > maxFreq) {
                        // We have a new mode, clear the list, add node.val to
                        // the list. We also need to update the maxFreq
                        modeList.clear();
                        modeList.add(node.val);
                        maxFreq = curFreq;
                    } else if (curFreq == maxFreq) {
                        modeList.add(node.val);
                    }
                    maxFreq = Math.max(maxFreq, curFreq);

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