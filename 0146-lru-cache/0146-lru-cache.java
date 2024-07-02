class LRUCache {
   class Node {
        int key;
        int value;
        Node prev;
        Node next;
        
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    
    private final int capacity;
    private final Map<Integer, Node> cache;
    private Node head;
    private Node tail;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.head = new Node(0, 0); // Dummy head node
        this.tail = new Node(0, 0); // Dummy tail node
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }
    
    public int get(int key) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            // Move accessed node to the front
            removeNode(node);
            addNodeToHead(node);
            return node.value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            node.value = value;
            removeNode(node);
            addNodeToHead(node);
        } else {
            if (cache.size() >= capacity) {
                // Remove the least recently used node (tail.prev)
                Node toRemove = tail.prev;
                removeNode(toRemove);
                cache.remove(toRemove.key);
            }
            // Add new node to the front
            Node newNode = new Node(key, value);
            cache.put(key, newNode);
            addNodeToHead(newNode);
        }
    }
    
    private void addNodeToHead(Node node) {
        Node next = head.next;
        head.next = node;
        node.prev = head;
        node.next = next;
        next.prev = node;
    }
    
    private void removeNode(Node node) {
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
    }
}


/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */