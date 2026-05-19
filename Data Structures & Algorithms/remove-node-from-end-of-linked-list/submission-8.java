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
        // [1, 2, 3, 4, 5, 6] n = 2

        // we can traverse the linkedlist once to determine the size
        // size - n = index we have to remove (0-based)
        // after determined the index, we can traverse the linked list index time
        // and remove the node

        if (head == null) {
            return null;
        }

        ListNode current = head;
        int size = 0;

        while (current != null) {
            size++;
            current = current.next;
        }

        int index = size - n;
        if (index == 0) {
            return head.next;
        }

        current = head;
        ListNode prev = null;
        int i = 0;

        while (current != null) {
            if (i == index) {
                removeNode(prev, current);
                break;
            }

            prev = current;
            current = current.next;
            i++;
        }
 
        return head;
    }

    private void removeNode(ListNode prev, ListNode current) {
        if (prev != null) {
            prev.next = current.next;
        }
        current.next = null;
    }
}
