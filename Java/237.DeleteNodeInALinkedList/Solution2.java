/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
	// ! Note that the node would not be the tail!
	// Straightforward way: Breaking the list
    public void deleteNode(ListNode node) {
    	ListNode cur = node, prev = null;
    	while (cur.next != null) {
    		cur.val = cur.next.val;
    		prev = cur;
    		cur = cur.next;
    	}
    	prev.next = null;
    }

    // The smart way: Just copy the one next to node and remove it.
    public void deleteNode(ListNode node) {
    	node.val = node.next.val;
    	node.next = node.next.next;
    }
}