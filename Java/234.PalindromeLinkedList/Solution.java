/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isPalindrome(ListNode head) {
    	ListNode slow = head, fast = head;
    	while (fast != null && fast.next != null) {
    		slow = slow.next;
    		fast = fast.next.next;
    	}
    	ListNode second = fast == null ? slow : slow.next;
    	second = reverse(second);
    	// No need to break the list because the two halves 
    	// of our list would always have equal length.
    	while (second != null) {
    		if (head.val != second.val) return false;
    		head = head.next;
    		second = second.next;
    	}
    	return true;
    }
    
    private ListNode reverse(ListNode head) {
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