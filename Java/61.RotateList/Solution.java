class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { this.val = x; }
}
public class Solution {
	//Standard three steps
	public ListNode rotateRight(ListNode head, int k) {
		if(head == null || head.next == null) return head;
		//Get length
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode p = dummy;
		ListNode last = null;
		int len = 0;
		while(p.next != null) {
			p = p.next;
			len++;
		}
		
		last = p;
		k = k % len;
		p = dummy;
		int counter = len - k;
		while(counter > 0) {
			p = p.next;
			counter--;
		}
		last.next = dummy.next;
		dummy.next = p.next;
		p.next = null;
		
		return dummy.next;
 	}
	
	//Form a circle more preferable
	/*public ListNode rotateRight(ListNode head, int k) {
		if(head == null || head.next == null || k == 0) 
			return head;		
		ListNode cur = head;
		int len = 1;
		while(cur.next != null) {
			cur = cur.next;
			len++;
		}
		//Form a circle
		cur.next = head;
		k = k % len;
		//Move cur forward to the breaking point
		for(int i = 0; i < len - k; i++) {
			cur = cur.next;
		}
		head = cur.next;
		cur.next = null;
		
		return head;
	}*/
	
}
