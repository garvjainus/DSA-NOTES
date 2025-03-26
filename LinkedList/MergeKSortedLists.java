/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 // Continue merging until we have a single merged list
        while (interval < amount) {
            // Merge pairs of lists in increasing interval sizes
            for (int i = 0; i < amount - interval; i += interval * 2) {
                lists[i] = merge2Lists(lists[i], lists[i + interval]); // Merge lists at i and i+interval
            }
            interval *= 2; // Double the interval to merge larger groups next
        }

        return amount > 0 ? lists[0] : null; // Return
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        while (lists.length > 1) {
            List<ListNode> mergedLists = new ArrayList<>();
            for (int i = 0; i < lists.length; i += 2) {
                ListNode l1 = lists[i];
                ListNode l2 = (i + 1) < lists.length ? lists[i + 1] : null;
                mergedLists.add(merge2Lists(l1, l2));
            }
            lists = mergedLists.toArray(new ListNode[0]);
        }
        return lists[0];
    }

    public ListNode merge2Lists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode point = head;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                point.next = l1;
                l1 = l1.next;
            } else {
                point.next = l2;
                l2 = l2.next;
            }
            point = point.next;
        }
        if (l1 == null) {
            point.next = l2;
        } else {
            point.next = l1;
        }
        return head.next;
        /*
        int k = lists.length;
        List<Integer> o = new ArrayList<>();
        for(ListNode l: lists){
            while(l != null){
                o.add(l.val);
                l = l.next;
            }
        }
        Collections.sort(o);
        if(o.isEmpty()){
            return null;
        }
        ListNode head = new ListNode(o.get(0));
        ListNode curr = head;
        for (int i = 1; i < o.size(); i++) {
            curr.next = new ListNode(o.get(i));
            curr = curr.next;
        }
        return head;
        */
        
    }
}