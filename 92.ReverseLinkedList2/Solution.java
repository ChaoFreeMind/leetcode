//Reverse a linked list from position m to n. Do it in-place and in one-pass.
//
//For example:
//Given 1->2->3->4->5->NULL, m = 2 and n = 4,
//
//return 1->4->3->2->5->NULL.
//
//Note:
//Given m, n satisfy the following condition:
//1 ≤ m ≤ n ≤ length of list.

// Definition for singly-linked list.
class ListNode {
	int val;
	ListNode next;
	ListNode(int x) {
		val = x;
	}
}

public class Solution {
	public ListNode reverseBetween(ListNode head, int m, int n) {
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode prev = dummy, cur = head;
		int count = 1;
		ListNode connect = null;//connect this node to the tail of reversed list.
		ListNode tail = null;//tail of the reversed list
		while(count <= n) {
			if(count < m) {
				prev = cur;
				cur = cur.next;
			} else if(count == m) {
				tail = cur;
				connect = prev;
				cur = cur.next;
			} else {
				//Reverse
				ListNode next = cur.next;
				cur.next = prev;
				prev = cur;
				cur = next;
			}
			count++;
		}
		//prev points to the head of the reversed list, cur points to the right connecting point.
		if(connect != null) connect.next = prev;
		if(tail != null) tail.next = cur;
		
		return dummy.next;
	}
}