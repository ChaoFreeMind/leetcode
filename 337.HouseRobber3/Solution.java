class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

}

public class Solution {

	//Most basic way. TLE because of too many overlaps.
    /*public int rob(TreeNode root) {
    	if(root == null) return 0;

    	int rob = root.val;//Total profit if rob current house.
    	if(root.left != null) {
    		rob += rob(root.left.left) + rob(root.left.right);
    	} 

    	if(root.right != null) {
    		rob += rob(root.right.left) + rob(root.right.right);
    	}
    	//Compute profit if not rob current house
    	int notrob = rob(root.left) + rob(root.right);


    	return Math.max(rob, notrob);
    }*/

    //Improve 9ms
    /*private Map<TreeNode, Integer> map = new HashMap<>();

    public int rob(TreeNode root) {
    	if(root == null) return 0;
    	if(map.containsKey(root)) return map.get(root);

    	int rob = root.val;//Total profit if rob current house.
    	if(root.left != null) {
    		rob += rob(root.left.left) + rob(root.left.right);
    	} 

    	if(root.right != null) {
    		rob += rob(root.right.left) + rob(root.right.right);
    	}

    	//Compute profit if not rob current house
    	int notrob = rob(root.left) + rob(root.right);

    	map.putIfAbsent(root, Math.max(rob, notrob));

    	return Math.max(rob, notrob);
    }*/

    public int rob(TreeNode root) {
    	int[] result = helper(root);
    	return Math.max(result[0], result[1]);
    }
    //Helper function, return an array of size 2, first element is the profit if not rob current house.
    private int[] helper(TreeNode root) {
    	int[] result = new int[2];
    	if(root == null) return result;

    	int[] left = helper(root.left);
    	int[] right = helper(root.right);

    	result[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
    	result[1] = root.val + left[0] + right[0];

    	return result;
    }
}