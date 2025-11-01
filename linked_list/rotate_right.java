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

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return null;

        ListNode traverse = head;
        int pos = 0;
        int total = 0;
        while (traverse != null) {
            total++;
            traverse = traverse.next;
        }
        k = k % total;
        if (k == 0) return head;
        traverse = head;
        while (traverse != null && pos < total - k - 1) {
            traverse = traverse.next;
            pos++;
        }
        ListNode tempHead = traverse.next;

        traverse.next = null;
        traverse = tempHead;
        while (traverse != null && traverse.next != null) {
            traverse = traverse.next;
        }
        if (traverse != null) {
            traverse.next = head;
        }

        return tempHead;
    }
}
