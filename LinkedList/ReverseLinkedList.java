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
    public ListNode reverseList(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;
        ListNode next = null;
        while(curr != null){
            //this saves the next node which points to the rest of the linkedlist
            next = curr.next;
            //this reverses pointers so the current value now points to the prev linkedlist that has the reversed values
            curr.next = prev;
            //saves the linkedlist with reversed values for futuer use including the new curr node
            prev = curr;
            //this line is to 
            curr = next;
        }
        return prev;
    }
}