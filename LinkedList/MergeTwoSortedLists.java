class Solution {
    public ListNode mergeTwoLists(ListNode head1, ListNode head2) {
        // Initialize a dummy node to build the final merged list.
        ListNode dummy = new ListNode(0);
        ListNode final1 = dummy; // final1 is a pointer to the current node in the merged list.
        
        // Traverse both lists until one is exhausted.
        while (head1 != null && head2 != null) {
            if (head1.val < head2.val) {
                final1.next = head1;
                head1 = head1.next;
            } else {
                final1.next = head2;
                head2 = head2.next;
            }
            final1 = final1.next;
        }
        
        // Attach the remaining part of the non-exhausted list.
        if (head1 != null) {
            final1.next = head1;
        } else {
            final1.next = head2;
        }
        
        // Return the merged list, skipping the dummy node.
        return dummy.next;
    }
}