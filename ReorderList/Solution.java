//Given a singly linked list L: L0→L1→…→Ln-1→Ln,
//reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
//
//You must do this in-place without altering the nodes' values.
//
//For example,
//Given {1,2,3,4}, reorder it to {1,4,2,3}.
class ListNode {
	int val;
	ListNode next;
	ListNode(int x) {
		val = x;
	}
}
public class Solution {

	
	public static void main(String[] args) {
		
		Solution s = new Solution();
		
		ListNode head = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		
		head.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = null;
		s.reorderList(head);
		
		
		
	}
	
	private void printList(ListNode head) {
		ListNode cur = head;
		while(cur != null) {
			System.out.print(cur.val + " ");
			cur = cur.next;
		}
		
	}
	
	public void reorderList(ListNode head) {
		
		int len = getLen(head);
		
		//Break the list into 2 halves 1->2 and 3->4
		ListNode secHead = breakList(head, len); 
		
		//2 halves are stored as heads[0] and heads[1]
		secHead = this.reverse(secHead);
		
		//Reverse the second half 3->4 to 4->3
		//Merge 2 list 1->4->2->3
		merge(head, secHead);	
	}
	
	private int getLen(ListNode head) {
		int len = 0;
		ListNode cur = head;
		while(cur != null) {
			len++;
			cur = cur.next;
		}
		return len;
	}
	
	//Break the list into 2 lists and return the head of the second half
	private ListNode breakList(ListNode head, int len) {
		ListNode cur = head;
		int move = len % 2 == 0 ? len / 2 - 1: len / 2;
		for(int i = 0; i < move; i++) {
			cur = cur.next;
		}
		ListNode newHead = cur.next;
		cur.next = null;
		return newHead;
		
	}
	
	private ListNode reverse(ListNode head) {
		ListNode pre = null;
		ListNode cur = head;
		ListNode next = null;
		while(cur != null) {
			
			next = cur.next;
			cur.next = pre;
			pre = cur;
			cur = next;
			
		}
		
		return pre;
	}
	
	private ListNode merge(ListNode l1, ListNode l2) {
		ListNode p = l1;
		ListNode q = l2;
		ListNode temp = null;
		while(p != null) {
			temp = p.next;
			p.next = q;
			p = q;
			q = temp;
		}
		
		
		return l1;
		
	}
	
}
