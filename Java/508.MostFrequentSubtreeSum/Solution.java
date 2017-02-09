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

    // Sum to frequency map
    private Map<Integer, Integer> sumToFreq = new HashMap<>();

    // Max frequency
    private int maxFreq = 0; 

    /**
     * Time complexity: O(n) 
     * Space complexity: O(n)
     */ 
    public int[] findFrequentTreeSum(TreeNode root) {
        
        computeSum(root);
        List<Integer> resList = new ArrayList<>();
        
        for (Map.Entry<Integer, Integer> entry: sumToFreq.entrySet()) {
            if (entry.getValue() == maxFreq) {
                resList.add(entry.getKey());
            }
        }

        // return resList.stream().mapToInt(i -> i).toArray();
        return intListToArray(resList);
    }
    /**
     * For each node, compute its sum and update the sumToFreq map as well as 
     * max frequency.
     * @return sum of all nodes rooted as root
     */
    private int computeSum(TreeNode root) {
        if (root == null) return 0;
        // Collect sum from bottom up
        int sum = root.val + computeSum(root.left) + computeSum(root.right);
        // Compute new frequency
        int freq = sumToFreq.getOrDefault(sum, 0) + 1;
        // Update max frequency
        maxFreq = Math.max(maxFreq, freq);
        // Update sum-to-frequency map
        sumToFreq.put(sum, freq);
        return sum;
    }

    /**
     * Utility function that converts Integer list to int array
     */
    private int[] intListToArray(List<Integer> list) {
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

}