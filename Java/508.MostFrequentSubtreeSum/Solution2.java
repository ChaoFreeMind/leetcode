// Given the root of a tree, you are asked to find the most frequent subtree 
// sum. The subtree sum of a node is defined as the sum of all the node values 
// formed by the subtree rooted at that node (including the node itself). 
// So what is the most frequent subtree sum value? If there is a tie, 
// return all the values with the highest frequency in any order.

// Examples 1
// Input:

//   5
//  /  \
// 2   -3
// return [2, -3, 4], since all the values happen only once, return all of them 
// in any order.
// Examples 2
// Input:

//   5
//  /  \
// 2   -5
// return [2], since 2 happens twice, however -5 only occur once.
// Note: You may assume the sum of values in any subtree is in the range of 
// 32-bit signed integer.

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

    private int maxFreq = 0;

    public int[] findFrequentTreeSum(TreeNode root) {
        // Sum => Freqency
        Map<Integer, Integer> sumFreqMap = new HashMap<>();
        computeSum(root, sumFreqMap);
        List<Integer> resList = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry: sumFreqMap.entrySet()) {
            if (maxFreq == entry.getValue()) {
                resList.add(entry.getKey());
            }
        }

        // Convert List to int[]
        return convertIntListToArray(resList);
    }

    private int[] convertIntListToArray(List<Integer> list) {
        int[] res = new int[list.size()];
        int i = 0;
        for (i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }


    private int computeSum(TreeNode root, Map<Integer, Integer> sumFreqMap) {
        if (root == null) return 0;
        int subSum = computeSum(root.left, sumFreqMap) + computeSum(root.right, sumFreqMap) + root.val;
        int freq = sumFreqMap.getOrDefault(subSum, 0) + 1;
        // Update maxFrequency if necessary
        maxFreq = Math.max(maxFreq, freq);
        sumFreqMap.put(subSum, freq);
        return subSum;
    }
}