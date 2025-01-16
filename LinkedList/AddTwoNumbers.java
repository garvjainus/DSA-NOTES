/**
 * 1. 2+5 = 7 
 * 2. 4 + 6 = 10 
 * 3. carry the one
 * 4. leave the zero
 * 3 +4 = 7 + 1 cause of carry thigny 
 * if the last calculation is a double digit, need to add value at the beginning
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode();
        ListNode dummy = result; 
        int carry = 0;
        while(l1 != null || l2 != null){
            int val = carry;
            if(l1 != null){
                val += l1.val;
                l1 = l1.next;
            }
            if(l2 != null){
                val += l2.val;
                l2 = l2.next;
            }
            carry = val/10;
            val = val%10; 
            dummy.next = new ListNode(val);
            dummy = dummy.next;  
        }
        if(carry > 0){
            dummy.next = new ListNode(carry);
        }
        return result.next; 
    }
}