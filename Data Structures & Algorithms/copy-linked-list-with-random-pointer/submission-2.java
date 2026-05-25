/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        // intuition is to create a map that maps the original node and the newly created node
        // then run through the map, adjust the pointers

        Map<Node, Node> nodeMap = new HashMap<>();

        Node curr = head;
        while (curr != null) {
            Node newNode = new Node(curr.val);

            nodeMap.put(curr, newNode);
            curr = curr.next;
        }

        for (Node node : nodeMap.keySet()) {
            nodeMap.get(node).next = nodeMap.get(node.next);
            nodeMap.get(node).random = nodeMap.get(node.random);
        }

        return nodeMap.get(head);
    }
}
