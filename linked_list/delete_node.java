/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {

    public void deleteNode(ListNode node) {
        if (node == null) {
            return;
        }

        node.val = node.next.val;
        node.next = kill(node.next);
    }

    ListNode kill(ListNode node) {
        if (node.next == null) {
            return null;
        }

        node.val = node.next.val;
        node.next = kill(node.next);
        return node;
    }
}
