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
        // create copy of all nodes and put in Map<nodeVal, randomVal>
        // 
        if (head == null) {
            return null;
        }

        Node currentNode = head;

        Map<Node, Node> map = new HashMap<>();

        while (currentNode != null) {
            Node newNode = new Node(currentNode.val);
            map.put(currentNode, newNode);

            currentNode = currentNode.next;
        }

        for (Node original : map.keySet()) {
            map.get(original).next = map.get(original.next);
            map.get(original).random = map.get(original.random);
        }

        return map.get(head);
    }
}
