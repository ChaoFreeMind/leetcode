public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    	int lenA = getLen(headA);
    	int lenB = getLen(headB);
    	ListNode longer = lenA > lenB ? headA : headB;
    	ListNode shorter = longer == headA ? headB : headA;
    	//Move longer to make it equals to the shorter one
    	for(int i = 0; i < Math.abs(lenA - lenB); i++) {
    		longer = longer.next;
    	}
    	
    	while(longer != shorter && longer != null && shorter != null) {
    		longer = longer.next;
    		shorter = shorter.next;
    	}
    	
    	return longer == shorter ? longer : null;
    }
    
    
    //Return the length of a list
    private int getLen(ListNode head) {
    	ListNode p = head;
    	int len = 0;
    	while(p != null) {
    		len++;
    		p = p.next;
    	}
    	
    	return len;
    }
    
}