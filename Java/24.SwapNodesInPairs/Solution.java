//Given a linked list, swap every two adjacent nodes and return its head.
//
//For example,
//Given 1->2->3->4, you should return the list as 2->1->4->3.
//
//Your algorithm should use only constant space. 
//You may not modify the values in the list, only nodes itself can be changed.

//Definition for singly-linked list.
class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}

public class Solution {
	public ListNode swapPairs(ListNode head) {
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode prev = dummy;
		ListNode cur = head;
		
		while(cur != null && cur.next != null) {
			//First node: cur, Second node: cur.next
			ListNode first = cur, second = cur.next;
			first.next = second.next;
			second.next = first;
			prev.next = second;
			prev = first;
			cur = cur.next;
		}
		
		return dummy.next;
	}
}