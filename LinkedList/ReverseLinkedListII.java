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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head == null){
            return null;
        }
        if(left == right){
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode preLeft = dummy;

        for(int i = 1; i < left; i++){
            preLeft = preLeft.next;
        }
        
        ListNode curr = preLeft.next; 

        ListNode prev = null;
        ListNode next = null;
        for(int i = left; i <= right; i++){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        preLeft.next.next = curr;
        preLeft.next = prev;
        return dummy.next;
    }
}