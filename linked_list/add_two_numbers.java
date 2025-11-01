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

    int carry = 0;

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;
        while (l1 != null || l2 != null) {
            current.next = add(l1, l2);
            current = current.next;
            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
            if (this.carry != 0 && l1 == null && l2 == null) {
                current.next = new ListNode(carry);
            }
        }
        return dummy.next;
    }

    private ListNode add(ListNode l1, ListNode l2) {
        int sum = carry;
        if (l1 != null && l2 != null) {
            sum += l1.val + l2.val;
        } else if (l2 == null && l1 != null) {
            sum += l1.val;
        } else if (l1 == null && l2 != null) {
            sum += l2.val;
        }
        this.carry = sum / 10;
        if (sum >= 10) {
            sum = sum % 10;
        }
        return new ListNode(sum);
    }
}
