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
    public ListNode mergeKLists(ListNode[] lists) {
       if(lists == null || lists.length == 0) {
            return null;
       } 

       PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a,b) -> a.val - b.val);

       for(int i=0; i<lists.length; i++) {
            if(lists[i] != null) {
                minHeap.offer(lists[i]);
            }
       }

       ListNode dummy = new ListNode(-1);
       ListNode curr = dummy;

       while(!minHeap.isEmpty()) {
            ListNode minNode = minHeap.poll();
            curr.next = minNode;
            curr = curr.next;

            if(minNode.next != null) {
                minHeap.offer(minNode.next);
            }
       }

        return dummy.next;
    }
}