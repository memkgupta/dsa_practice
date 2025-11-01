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

    public ListNode deleteDuplicates(ListNode head) {
        Set<Integer> set = new HashSet<>();
        ListNode traverse = head;
        ListNode prev = null;
        while (traverse != null) {
            if (set.contains(traverse.val)) {
                prev.next = traverse.next;
                traverse.next = null;
                traverse = prev.next;
            } else {
                set.add(traverse.val);
                prev = traverse;
                traverse = traverse.next;
            }
        }
        return head;
    }
}
