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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode curr = head;
        while(curr != null && curr.next != null){
            if(curr.next.val == curr.val){
                curr.next = curr.next.next;
            } else {
                //has to be in else so you dont skip consecutive duplicates (e.g. 1 -> 1 -> 1)
                curr= curr.next;
            }
        }
        return head;
       
    }
}