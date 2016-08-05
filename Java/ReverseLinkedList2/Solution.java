//Reverse a linked list from position m to n. Do it in-place and in one-pass.
//
//For example:
//Given 1->2->3->4->5->NULL, m = 2 and n = 4,
//
//return 1->4->3->2->5->NULL.
//
//Note:
//Given m, n satisfy the following condition:
//1 ≤ m ≤ n ≤ length of list.
class ListNode {
	int val;
	ListNode next;
	public ListNode(int x) { val = x; }
}

public class Solution {
	
	public ListNode reverseBetween(ListNode head, int m, int n) {
		
		int index = 1;
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode prev = dummy;
		ListNode cur = head;
		ListNode connectHead = null;
		
		while(index <= n) {//Not sure
			
			if(index < m) {
				prev = cur;
				cur = cur.next;
			} else if(index == m) {
				//Only need to record connecting point here
				connectHead = prev;
				prev = cur;
				cur = cur.next;
			} else {
				ListNode next = cur.next;
				cur.next = prev;
				prev = cur;
				cur = next;
			}
			index++;
		}
		
		//Connect sublist onto main list
		connectHead.next.next = cur;
		connectHead.next = prev;
		
        return dummy.next;
    }
	
}
