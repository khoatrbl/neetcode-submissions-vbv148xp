class LRUCache {
    private Map<Integer, Node> map = new HashMap<>();
    private int capacity;
    private Node head;
    private Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        // Create dummy head and tail nodes to avoid edge cases
        this.head = new Node(-1, -1);
        this.tail = new Node(-1, -1);
        this.head.next = tail;
        this.tail.prev = head;
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }

        Node node = map.get(key);

        removeNodeFromCurrentPosition(node);
        moveToHead(node);

        return node.value;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;

            removeNodeFromCurrentPosition(node);
            moveToHead(node);
        } else {
            if (map.size() == capacity) {
                Node lru = tail.prev;
                map.remove(lru.key);
                removeNodeFromCurrentPosition(lru);
            }
            Node newNode = new Node(key, value);
            moveToHead(newNode);
            map.put(key, newNode);
            
        }
        
    }
    private void removeNodeFromCurrentPosition(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void moveToHead(Node node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }

    class Node {
        int key, value;
        Node prev, next;

        Node(int key, int value)  {
            this.key = key;
            this.value = value;
        }
    }
}
