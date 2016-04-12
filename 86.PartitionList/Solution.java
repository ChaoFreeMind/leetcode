/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode partition(ListNode head, int x) {
		if(head == null) return head;
		ListNode dummySmall = new ListNode(0), small = dummySmall;//small always points to the end of small list
		ListNode dummyLarge = new ListNode(0), large = dummyLarge;//large always points to the end of large list
		ListNode cur = head;
		
		//We need smaller to be the head, connect last node in smaller to the head of larger list
		while(cur != null) {
			if(cur.val < x) {//Add to smaller list
				small.next = cur;
				small = cur;
			} else {//Add to larger list
				large.next = cur;
				large = cur;
			}
			cur = cur.next;
		}
		small.next = dummyLarge.next;
		large.next = null;
		
		return dummySmall.next;
	}
}