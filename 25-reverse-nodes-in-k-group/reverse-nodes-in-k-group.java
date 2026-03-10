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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || head.next == null) return head;

         // Check if there are at least k nodes (speical case)
        ListNode temp = head;
        int count = 0;
        while(count < k && temp != null){
            temp = temp.next;
            count++;
        }

        if(count < k) return head;

        // Now that's my real code

        ListNode prev = null;
        ListNode curr = head;
        count = 0;

        while(count < k && curr != null) {
            ListNode next = curr.next;
            curr.next = prev;       
            prev = curr;
            curr = next;
            count++;
        }

        if(curr!=null) {
        ListNode restOfTheList = reverseKGroup(curr,k);
        head.next = restOfTheList;
        }

        return prev;
        
    }
}