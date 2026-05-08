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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = add(l1, l2, 0);

        return head;
    }

    public ListNode add(ListNode p, ListNode q, int carry) {
        if (p == null && q == null && carry == 0) {
            return null;
        }

        int pval = 0;
        int qval = 0;

        if (p != null) {
            pval = p.val;
        }

        if (q != null) {
            qval = q.val;
        }

        int sum = pval + qval + carry;

        int nextCarry = sum / 10;

        ListNode newNode = add(
            (p != null) ? p.next : null,
            (q != null) ? q.next : null,
            nextCarry
        );

        return new ListNode(sum % 10, newNode);
    }
}
