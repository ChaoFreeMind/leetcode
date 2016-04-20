class ListNode {
	int val;
	ListNode next;
	ListNode(int x) {
		this.val = x;
	}
}

public class Solution {
	
	//Very interesting problem!
	public ListNode insertionSortList(ListNode head) {
		if(head == null) return null;
        ListNode sorted = head;
        ListNode unsorted = head.next;
        sorted.next = null;
        
		ListNode sortedDummy = new ListNode(0);
		sortedDummy.next = sorted;
        
        while(unsorted != null) {
        	
        	ListNode prev = sortedDummy;
        	ListNode p = sortedDummy.next;
        	while(p != null && p.val < unsorted.val) {
        		prev = p;
        		p = p.next;
        	}
        	
        	prev.next = unsorted;
        	ListNode unsortedNext = unsorted.next;
        	unsorted.next = p;
        	unsorted = unsortedNext;
        }
        
        return sortedDummy.next;
    }
}
