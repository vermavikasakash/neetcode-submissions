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
        int count = 0;
        ListNode curr = head;

        while (curr != null) {
            curr = curr.next;
            count++;
        }
       
        
        ListNode sentinal = new ListNode(0);
        sentinal.next = head;
        curr = sentinal;
        int traverse = count - n; // ending 1 before

        while (traverse > 0) {
            curr = curr.next;
            traverse--;
        }
        curr.next = curr.next.next;
        return sentinal.next;
    }
}
