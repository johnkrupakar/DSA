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
        int diff = getDifference(headA,headB);
        //if diff is negative move the head2 and until diff becomes 0
        if(diff < 0){
            while(diff++ != 0){
                headB = headB.next;
            }
        }
        else{ //if diff is positive move the head1 until diff becomes 0 
            while(diff-- != 0){
                headA = headA.next;
            }
        }
        //now move both pointers simultaneouls
        while(headA != null){
            if(headA == headB){
                return headA;
            }
            headB = headB.next;
            headA = headA.next;
        }
        return null;
    }
    public static int getDifference(ListNode head1, ListNode head2){
        int length1 = 0;
        int length2 = 0;

        while(head1 != null || head2 != null){
            if(head1 != null){
                ++length1;
                head1 = head1.next;
            }
            if(head2 != null){
                ++length2;
                head2 = head2.next;
            }
        }
        return length1 - length2; //if difference is neg-> length of list2 > length of list1 else vice-versa
    }
}