// You need to find the largest value in each row of a binary tree.

// Example:
// Input: 

//           1
//          / \
//         3   2
//        / \   \  
//       5   3   9 

// Output: [1, 3, 9]

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

    public List<Integer> largestValues(TreeNode root) {
        
        List<Integer> res = new ArrayList<>();

        Deque<TreeNode> row = new LinkedList<>();
        if (root != null) {
            row.add(root);
        }

        while (!row.isEmpty()) {
            // Each iteration traverses one row.
            int count = row.size();
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < count; i++) {
                TreeNode node = row.poll();
                max = Math.max(max, node.val);
                
                if (node.left != null) {
                    row.offer(node.left);
                }

                if (node.right != null) {
                    row.offer(node.right);  
                } 
            }
            // At the end of each iteration, add the max to the result list.
            res.add(max);
        }

        return res;

    }


}