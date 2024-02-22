/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        //finding the middle
        ListNode prev = null;
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;

        //sort each half
        ListNode left = sortList(head);
        ListNode right = sortList(slow);

        //mearge left and right linkedlist
        return merge(left,right);
    }
    public static ListNode merge(ListNode left,ListNode right){
        ListNode tempHead = new ListNode(0);
        ListNode pointer = tempHead;

        while(left != null && right != null){
            if(left.val < right.val){
                pointer.next = left;
                left = left.next;
            }
            else{
                pointer.next = right;
                right = right.next;
            }
            pointer = pointer.next;
        }
        if(left != null){
            pointer.next = left;
        }
        if(right != null){
            pointer.next = right;
        }
        return tempHead.next;
    }
}