/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
	//First attempt
    //Iterate through the rest of the list, assign the value of the current node to previous one, delete the last node.
	/*public void deleteNode(ListNode node) {
		ListNode prev = node;
		ListNode cur = node.next;//cur will not be null at this point cuz prev is not tail
		prev.val = cur.val;
		while(cur.next != null) {
			prev = cur;
			cur = cur.next;
			prev.val = cur.val;
		}
		//cur is pointing at the tail of the list
		prev.next = null;
	}*/

	public void deleteNode(ListNode node) {
		cur.val = cur.next.val;
		cur.next = cur.next.next;
	}

}
