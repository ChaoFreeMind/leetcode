/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

public class Solution {

	// Optimal Solution
	public ListNode plusOne(ListNode head) {
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		// Find the last number that is not 9
		ListNode lastNotNine = dummy;
		ListNode cur = head;
		while (cur != null) {
			if (cur.val != 9) lastNotNine = cur;
			cur = cur.next;
		}
		lastNotNine.val++;
		cur = lastNotNine.next;
		while (cur != null) {
			cur.val = 0;
			cur = cur.next;
		}
		return dummy.val == 1 ? dummy : head;
	}

	// O(n) time and O(1) space. Not optimal though.
    public ListNode plusOne(ListNode head) {
        ListNode reversedHead = reverse(head);
        ListNode cur = reversedHead;
        boolean carry = true;
        while (cur != null && carry) {
        	if (cur.val == 9) {
        		cur.val = 0;
        	} else {
        		cur.val = cur.val + 1;
        		carry = false;
        	}
        	cur = cur.next;
        }
        head = reverse(reversedHead);
        if (carry) {
            ListNode newHead = new ListNode(1);
            newHead.next = head;
            head = newHead;
        }
        return head;
    }

    // Reverse linkedlist and return reversedHead.
    // O(n) time, O(1) space
    private ListNode reverse(ListNode head) {
    	if (head == null || head.next == null) return head;
    	ListNode cur = head, prev = null;
    	while (cur != null) {
    		ListNode next = cur.next;
    		cur.next = prev;
    		prev = cur;
    		cur = next;
    	}
    	return prev;
    }
}