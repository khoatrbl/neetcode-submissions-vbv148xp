class LRUCache {
    class Node {
        int key, value;
        Node prev, next;
        Node(int k, int v) { key = k; value = v; }
    }

    private Map<Integer, Node> map = new HashMap<>();
    private Node head, tail;
    private int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        // Create dummy head and tail nodes to avoid edge cases
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        
        Node node = map.get(key);
        removeNode(node);    // Remove from current position
        moveToHead(node);    // Move to front (Most Recently Used)
        return node.value;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;
            removeNode(node);
            moveToHead(node);
        } else {
            if (map.size() == capacity) {
                // Remove Least Recently Used (element right before tail)
                Node lru = tail.prev;
                map.remove(lru.key);
                removeNode(lru);
            }
            Node newNode = new Node(key, value);
            map.put(key, newNode);
            moveToHead(newNode);
        }
    }

    // --- Helper Methods for $O(1)$ List Manipulation ---
    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void moveToHead(Node node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }
}