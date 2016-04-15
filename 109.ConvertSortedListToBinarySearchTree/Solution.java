/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
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
    //We do not need to break the list!
	public TreeNode sortedListToBST(ListNode head) {
		return sortedListToBST(head, null);
	}
	//The range is [head, tail)
	private TreeNode sortedListToBST(ListNode head, ListNode tail) {
		if(head == tail) return null;
		ListNode slow = head, fast = head;
		while(fast != tail && fast.next != tail) {
			slow = slow.next;
			fast = fast.next.next;
		}
		
		TreeNode node = new TreeNode(slow.val);
		TreeNode left = sortedListToBST(head, slow);
		TreeNode right = sortedListToBST(slow.next, tail);
		node.left = left;
		node.right = right;
		return node;
	}
}