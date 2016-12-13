/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
	// Iterative beat 4% Why?
    public ListNode reverseList(ListNode head) {
        ListNode prev = null, next = null, cur = head;
        while (cur != null) {
        	next = cur.next;
        	cur.next = prev;
        	prev = cur;
        	cur = next;
        }
        return prev;
    }

    // Recursive
    public ListNode reverseList(ListNode head) {
    	if (head == null || head.next == null) return head;
    	ListNode newHead = reverseList(head.next);
    	// head.next is guarantee to be not null
    	head.next.next = head;
    	head.next = null;
    	return newHead;
    }
}