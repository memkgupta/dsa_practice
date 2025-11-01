class Solution {

    // This will store the new head of the reversed list
    ListNode ans;

    // Main function to reverse the list
    public ListNode reverseList(ListNode head) {
        // If the list is empty, return null
        if (head == null) {
            return head;
        }

        // Call the recursive reverse function
        reverse(head);

        // At this point, 'ans' will point to the new head
        // We manually break the original first node's next pointer to avoid cycles
        // (this is the original last node after reversal)
        head.next = null;

        return ans;
    }

    // Recursive function to reverse the list
    public ListNode reverse(ListNode head) {
        // Base case: If only one node is left or end of list is reached
        if (head == null || head.next == null) {
            // This becomes the new head of reversed list
            ans = head;
            return head;
        }

        // Store current node
        ListNode left = head;

        // Recurse till the last node
        ListNode right = reverse(head.next);

        // Now we are unwinding the recursion:
        // Make the next node point back to current node
        right.next = left;

        // Move right one step forward to return for next connection
        right = right.next;

        return right;
    }
}
