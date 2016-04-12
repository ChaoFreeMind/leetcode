//Given a sorted linked list, delete all nodes that have duplicate numbers, 
//leaving only distinct numbers from the original list.
//
//For example,
//Given 1->2->3->3->4->4->5, return 1->2->5.
//Given 1->1->1->2->3, return 2->3.

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) {
		val = x;
	}
}

public class Solution {
	//Worked it out the first time, but got fucked this time...I really need to calm down
	public ListNode deleteDuplicates(ListNode head) {
		if(head == null) return head;
		
		ListNode dummy = new ListNode(head.val - 1);
		dummy.next = head;
		
		ListNode cur = head, prev = dummy;
		
		while(cur != null && cur.next != null) {
			
			if(cur.val == cur.next.val) {
				ListNode breakPoint = prev;
				int val = cur.val;
				//Break here.
				while(cur != null && cur.val == val) {
					prev = cur;
					cur = cur.next;
				}
				//Reconnect
				breakPoint.next = cur;
			}
			
			prev = cur;
			cur = cur.next;
		}
		
		return dummy.next;
	}
}
