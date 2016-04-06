import java.util.ArrayList;
import java.util.List;

//Given a linked list, remove the nth node from the end of list and return its head.
//
//For example,
//
//   Given linked list: 1->2->3->4->5, and n = 2.
//
//   After removing the second node from the end, the linked list becomes 1->2->3->5.
//Note:
//Given n will always be valid.
//Try to do this in one pass.

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
}

public class Solution {
	//One pass, O(n) time, O(1) space
	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode dummy = new ListNode(0);
		ListNode slow = dummy, fast = dummy;
		dummy.next = head;
		//Keep a gap of n between fast and slow
		for(int i = 0; i < n; i++) {
			fast = fast.next;
		}
		//Maintain the gap
		while(fast.next != null) {
			fast = fast.next;
			slow = slow.next;
		}
		
		slow.next = slow.next.next;
		return dummy.next;
	}
	
	//First attempt O(n) time, O(n) space
	/*public ListNode removeNthFromEnd(ListNode head, int n) {
		if(n == 0 || head == null) return head;
		
		List<ListNode> nodes = new ArrayList<>();
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode cur = head;
		
		while(cur != null) {
			nodes.add(cur);
			cur = cur.next;
		}
		
		nodes.add(null);
		
		int length = nodes.size() - 1;
		
		if(length == n) {//Remove head
			return dummy.next.next;
		}
		
		nodes.get(length - n - 1).next = nodes.get(length - n + 1);
		return dummy.next;
	}
	*/
}
