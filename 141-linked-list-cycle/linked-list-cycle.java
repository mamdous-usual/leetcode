/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
                if (head == null || head.next == null) {
            return false;
        }

        // Initialize slow and fast pointers at the head
        ListNode slow = head;
        ListNode fast = head;

        // Traverse the list with two pointers
        while (fast != null && fast.next != null) {
            // Move slow pointer by 1 step
            slow = slow.next;

            // Move fast pointer by 2 steps
            fast = fast.next.next;

            // If slow and fast meet, a cycle exists
            if (slow == fast) {
                return true;
            }
        }

        // If fast reached the end, there is no cycle
        return false;

    }
}