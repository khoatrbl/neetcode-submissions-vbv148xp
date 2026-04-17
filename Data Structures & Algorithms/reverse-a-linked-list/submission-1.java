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
    public ListNode reverseList(ListNode head) {
        // Recursion

        if (head == null) {
            return null;
        }

        ListNode current = head;
        ListNode prev = null;

        return reverse(current, prev);

    }

    private ListNode reverse(ListNode current, ListNode prev) {
        if (current == null) {
            return prev;
        }

        ListNode next = current.next;

        current.next = prev;

        prev = current;

        return reverse(next, prev);
    }
}
