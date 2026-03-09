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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null) return head;
        if(head.next == null) return null;

        int totalNodes = 0;
        ListNode curr = head;
        while(curr != null) {
            totalNodes++;
            curr = curr.next;
        }

        int indexFromFront = totalNodes - n + 1;
        ListNode prev = null;
        curr = head;

        while(indexFromFront > 1 && curr != null) {
            prev = curr;
            curr = curr.next;
            indexFromFront--;
        }

        if(prev == null) {
            head = curr.next;
            curr.next = null;
            return head;
        }

        prev.next = curr.next;
        curr.next = null;
        
        return head;
    }
}