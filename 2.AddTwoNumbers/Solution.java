//You are given two linked lists representing two non-negative numbers. 
//The digits are stored in reverse order and each of their nodes 
//contain a single digit. Add the two numbers and return it as a linked list.
//
//Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
//Output: 7 -> 0 -> 8
class ListNode {
	int val;
	ListNode next;
	ListNode(int x) {
		val = x;
	}
}

public class Solution {
	
	public static void main(String[] args) {
		ListNode l1 = new ListNode(2);
		l1.next = new ListNode(4);
		l1.next.next = new ListNode(3);
		
		ListNode l2 = new ListNode(5);
		l2.next = new ListNode(6);
		l2.next.next = new ListNode(4);
		ListNode res = new Solution().addTwoNumbers(l1, l2);
		printList(res);
	}
	
	//Takes O(n) time and O(n) space but more concise
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {		
		ListNode dummy = new ListNode(0);
		ListNode p = dummy;
		boolean carry = false;
		int sum = 0;
		while(l1 != null || l2 != null) {
			if(l1 != null) {
				sum += l1.val;
				l1 = l1.next;
			} 
			if(l2 != null) {
				sum += l2.val;
				l2 = l2.next;
			}
			sum += carry ? 1 : 0;
			if(sum >= 10) {
				carry = true;
				sum %= 10;
			} else {
				carry = false;
			}
			p.next = new ListNode(sum);
			sum = 0;
			p = p.next;
		}
		
		if(carry) p.next = new ListNode(1);
		
		return dummy.next;
	}
	
	private static void printList(ListNode node) {
		while(node != null) {
			System.out.print(node.val + " ");
			node = node.next;
		}
	}
	
	//This solution will mess with the original l1 and l2 list. But it takes O(n) time and O(1) space
//	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//		
//		if(l1 == null || l2 == null) return null;
//		
//		ListNode head = l1;
//		boolean carry = false;
//		ListNode prev = null;
//		
//		while(l1 != null && l2 != null) {
//			l1.val += l2.val + (carry ? 1 : 0);
//			
//			if(l1.val >= 10) {
//				l1.val %= 10;
//				carry = true;
//			} else {
//				carry = false;
//			}
//			prev = l1;
//			l1 = l1.next;
//			l2 = l2.next;
//		}
//		
//		//if l1 reaches the end, reconnect the end of l1 to the rest of l2
//		if(l1 == null) {
//			prev.next = l2;
//			l1 = prev.next;
//			l2 = null;
//		}
//		
//		while(l1 != null && carry) {
//			l1.val += carry ? 1 : 0;
//			if(l1.val >= 10) {
//				l1.val %= 10;
//				carry = true;
//			} else {
//				carry = false;
//			}
//			prev = l1;
//			l1 = l1.next;
//		}
//		
//		if(carry && l1 == null) {
//			prev.next = new ListNode(1);
//		}
//		
//		return head;
//	}
}