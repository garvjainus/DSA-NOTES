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
        ListNode curr1 = headA;
        int count1 = 0;
        ListNode curr2 = headB;
        int count2 = 0;
        while(curr1 != null){
            curr1 = curr1.next;
            count1++;
        }
        while(curr2 != null){
            curr2 = curr2.next;
            count2++;
        }
        curr1 = headA;
        curr2 = headB;
        if(count1<count2){
            while(count2 != count1){
                curr2 = curr2.next;
                count2--;
            }
        } else {
             while(count2 != count1){
                curr1 = curr1.next;
                count1--;
            }
        }

        while(curr1 != curr2){
            curr1 = curr1.next;
            curr2 = curr2.next;
            
        }
        return curr1;
    }
}