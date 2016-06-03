class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
 }
 
public class Solution {

	//This solution is correct but not simple enough!
    public ListNode oddEvenList(ListNode head) {
    	if(head == null) return head;
        //ListNode dummy = new ListNode(0);
        //dummy.next = head;
        ListNode odd = head;
        ListNode even = odd.next;
        ListNode evenHead = odd.next;
        while(even != null && even.next != null) {
        	ListNode nextOdd = even.next;
        	ListNode nextEven = even.next.next;
        	odd.next = even.next;
        	even.next = even.next.next;

        	odd = nextOdd;
        	even = nextEven;
        }

        //Reconnect even to the end of odd list
		odd.next = evenHead;

        return head;
    }

}