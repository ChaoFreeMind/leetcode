/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return head;
        
		ListNode dummy = new ListNode(head.val - 1);
		ListNode prev = dummy;
		ListNode cur = head;
		dummy.next = head;
		while(cur != null && cur.next != null) {
			
			if(cur.val == cur.next.val) {
				int val = cur.val;
				ListNode breakPoint = prev;
				while(cur != null && cur.val == val) {
					cur = cur.next;
				}
				//Reconnect
				breakPoint.next = cur;
				prev = breakPoint;
			} else {
				prev = cur;
				cur = cur.next;
			}
			
		}
		
		return dummy.next;
    }
    
}