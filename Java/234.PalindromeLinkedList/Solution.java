/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

public class Solution {
	
	public boolean isPalindrome(ListNode head) {
		if(head == null || head.next == null) return true;
		//Move to mid point of the linked list, break the list
		ListNode prev = null, slow = head, fast = head;
		while(fast != null && fast.next != null) {
			prev = slow;
			slow = slow.next;
			fast = fast.next.next;
		}
		//Break the list
		prev.next = null;
		ListNode second = (fast == null) ? slow : slow.next;
		//Reverse the second part
		
		second = reverseList(second);
		
		//Go through 2 halves at the same time and see if they are identical
		
		while(second != null && head != null) {
			if(second.val != head.val) return false;
			second = second.next;
			head = head.next;
		}
		
		return true;
	}
	
	private ListNode reverseList(ListNode head) {
		ListNode prev = null, cur = head;
		while(cur != null) {
			ListNode next = cur.next;
			cur.next = prev;
			prev = cur;
			cur = next;
		}
		return prev;
	}
	
}