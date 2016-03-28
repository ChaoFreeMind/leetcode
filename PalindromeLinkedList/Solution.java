/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
   //Without using extra space, we can reverse the second half of the list, thus we need to find the mid point of the list.
	public boolean isPalindrome(ListNode head) {
		
		ListNode slow = head, fast = head;
		while(fast != null && fast.next != null) {
			
			slow = slow.next;
			fast = fast.next.next;
			
		}
		
		//In case of even length list: fast will be null, odd fast will be last element in the list.
		ListNode rightHead = null;
		if(fast == null) {
			rightHead = slow;
		} else {
			rightHead = slow.next;
		}
		
		rightHead = reverseList(rightHead);
		
		ListNode left = head, right = rightHead;
		while(right != null) {
			
			if(right.val != left.val) return false;
			
			left = left.next;
			right = right.next;
		}
		
		return true;
	}
	
	private ListNode reverseList(ListNode head) {
		
		ListNode cur = head;
		ListNode prev = null;
		ListNode next = null;
		while(cur != null) {
			
			next = cur.next;
			cur.next = prev;
			prev = cur;
			cur = next;
			
		}
		
		return prev;
	}
    // public boolean isPalindrome(ListNode head) {
    //     if(head == null) {
    //         return true;
    //     }
    //     List<Integer> list = new ArrayList<Integer>();
        
    //     ListNode p = head;
    //     while(p != null) {
    //         list.add(p.val);
    //         p = p.next;
    //     }
    //     System.out.println(list);
    //     int len = list.size();
    //     boolean isPalin = true;
    //     for(int i = 0, j = len - 1; i < len && j >= 0 && i < j; i++, j--) {
            
    //         if(!list.get(i).equals(list.get(j))) {
    //             isPalin = false;
    //             break;
    //         }
    //     }
    //     return isPalin;
        
    // }
}