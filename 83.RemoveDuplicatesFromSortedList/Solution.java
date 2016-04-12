class ListNode {
	int val;
	ListNode next;
	ListNode(int x) {
		val = x;
	}
}

public class Solution {
	//Shorter version
	public ListNode deleteDuplicates(ListNode head) {
		ListNode cur = head;
		
		while(cur != null && cur.next != null) {
			if(cur.val == cur.next.val) {
				cur.next = cur.next.next;
			} else {
				cur = cur.next;
			}
		}
		
		return head;
	}
	
	//Too long!
	/*public ListNode deleteDuplicates(ListNode head) {
		if(head == null) return head;
		ListNode dummy = new ListNode(head.val - 1);
		dummy.next = head;
		ListNode prev = dummy;
		ListNode cur = head;
		
		while(cur != null && cur.next != null) {
			if(cur.val == cur.next.val) {
				int val = cur.val;
				ListNode breakPoint = prev;
				while(cur != null && cur.val == val) {
					prev = cur;
					cur = cur.next;
				}
				breakPoint.next = prev;
				
			} else {
				prev = cur;
				cur = cur.next;
			}
		}
		
		return dummy.next;
	}*/
	
}