class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}

public class Solution {
	//First break the list into 2 halves, reverse the second half.
	//Connect nodes between 2 lists in zigzag fashion.
	public void reorderList(ListNode head) {
		if(head == null || head.next == null) return;
		
		ListNode second = breakList(head);
		second = reverse(second);
		zigzagMerge(head, second);
	}
	
	private ListNode breakList(ListNode head) {
		ListNode slow = head, fast = head, prev = null;
		while(fast != null && fast.next != null) {
			prev = slow;
			slow = slow.next;
			fast = fast.next.next;
		}
		prev.next = null;
		return slow;
	}
	
	private ListNode reverse(ListNode head) {
		ListNode prev = null;
		ListNode cur = head;
		while(cur != null) {
			ListNode next = cur.next;
			cur.next = prev;
			prev = cur;
			cur = next;
		}
		return prev;
	}
	//Tricky!!!
	private void zigzagMerge(ListNode first, ListNode second) {
		while(first != null) {
			ListNode firstNext = first.next;
			ListNode secondNext = second.next;
			first.next = second;
			if(firstNext == null) break;
			second.next = firstNext;
			first = firstNext;
			second = secondNext;
		}
	}
	
}