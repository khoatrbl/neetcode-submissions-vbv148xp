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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {        
        ListNode mergedList = merge(list1, list2);

        return mergedList;
    }

    private ListNode merge(ListNode node1, ListNode node2) {
        if (node1 == null && node2 == null) {
            return null;
        }

        if (node1 == null) {
            return node2;
        } 
        
        if (node2 == null) {
            return node1;
        }

        if (node1.val <= node2.val) {
            node1.next = merge(node2, node1.next);

            return node1;
        } else {
            node2.next = merge(node1, node2.next);
            return node2;
        }
    }
}