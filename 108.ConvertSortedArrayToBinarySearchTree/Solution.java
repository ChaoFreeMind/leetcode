public class Solution {
	public TreeNode sortedArrayToBST(int[] nums) {
		return buildBST(0, nums.length - 1, nums);
	}
	
	private TreeNode buildBST(int left, int right, int[] nums) {
		if(right < left) return null;
		int mid = left + (right - left) / 2;//Prevent overflow
		TreeNode root = new TreeNode(nums[mid]);
		root.left = buildBST(left, mid - 1, nums);
		root.right = buildBST(mid + 1, right, nums);
		
		return root;
	}
}