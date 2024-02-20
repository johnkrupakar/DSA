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
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode d1 = headA;
        ListNode d2 = headB;
    
        while(d1 != d2) {
            d1 = d1 == null? headB:d1.next; //if d1 becomes null asign d1 to secondHead or else move ahead
            d2 = d2 == null? headA:d2.next;  //if d2 becomes null asign d2 to FirstHead or else move ahead
        }
    
        return d1;
    }
}