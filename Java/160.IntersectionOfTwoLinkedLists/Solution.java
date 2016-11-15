/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    // Naive. O(n) space O(n) Time
    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {

        ListNode p = headA, q = headB;
        Set<ListNode> set = new HashSet<>();

        while (p != null || q != null) {

            if (p != null) {
                if (!set.add(p)) return p;
                p = p.next;
            }
            if (q != null) {
                if (!set.add(q)) return q;
                q = q.next;
            }
        }

        // No intersection
        return null;
    }

    // Improved O(n + m) Time, O(1) space where n and m are lengths of the two lists.
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        ListNode p = headA, q = headB;
        // Race and see which one reaches the end first
        while (p != null && q != null) {
            p = p.next;
            q = q.next;
        }
        ListNode longer = p == null ? q : p;
        // p points to the head of the longer list
        p = longer == p ? headA : headB;
        while (longer != null) {
            p = p.next;
            longer = longer.next;
        }
        // Now that p and q are at the starting line, let them race again.
        while (p != null && q != null) {
            if (p == q) return p;
            p = p.next;
            q = q.next;    
        }
        return null;
    }

    public ListNode getIntersectionNode3(ListNode headA, ListNode headB) {
        ListNode curA = headA, curB = headB;
        // When curA == curB == null, it means they will never have intersection.
        while (curA != curB) {
            curA = curA == null ? headB : curA.next;
            curB = curB == null ? headA : curB.next;
        }
        return curA;
    }

}