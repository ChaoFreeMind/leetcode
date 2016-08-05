class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}

public class Solution {
	
	public ListNode sortList(ListNode head) {
		
		if(head == null || head.next == null) return head;
		
		//Break the list into 2 halves
		ListNode slow = head, fast = head, prev = null;
		while(fast != null && fast.next != null) {
			prev = slow;
			slow = slow.next;
			fast = fast.next.next;
		}
		//At this point, prev is pointing to the tail of left list, slow is pointing to the head of right list. 
		prev.next = null;
		
		return merge(sortList(head), sortList(slow));
	}
	
	private ListNode merge(ListNode l1, ListNode l2) {
		ListNode dummy = new ListNode(0);
		ListNode cur = dummy;
		
		while(l1 != null && l2 != null) {
			if(l1.val < l2.val) {
				cur.next = l1;
				cur = cur.next;
				l1 = l1.next;
				cur.next = null;
			} else {
				cur.next = l2;
				cur = cur.next;
				cur = l2;
				l2 = l2.next;
				cur.next = null;
			}
		}
		
		cur.next = l1 != null ? l1 : l2;
		
		return dummy.next;
	}
	
}